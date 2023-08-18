package by.itclass.controllers;

import by.itclass.model.entities.Country;
import by.itclass.model.services.CountryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@WebServlet(name="twoConditionControllers",urlPatterns = "/criteria")
public class TwoConditionsController extends HttpServlet {
    private CountryService countryService;

    @Override
    public void init() throws ServletException {
        countryService = new CountryService();//инициализируем в методе init countryService
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        List<Country> countries = countryService.getCountriesByCriteria(params);
        if(!countries.isEmpty()){
            req.setAttribute("countries",countries);
        }else{

            req.setAttribute("message","Countries are not found");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/countries.jsp");
        requestDispatcher.forward(req,resp);

    }

}
