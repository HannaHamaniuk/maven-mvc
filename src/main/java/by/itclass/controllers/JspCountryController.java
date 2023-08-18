package by.itclass.controllers;

import by.itclass.model.db.DbInMemory;
import by.itclass.model.entities.Country;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "jspCountryController", urlPatterns = "/jspSearch")
public class JspCountryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Country country = DbInMemory.findCountryByName(name);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/country.jsp");

        if(Objects.nonNull(country)){
            req.setAttribute("country",country);//в атрибут можно просетать не просто строку а объект, чтоб потом jsp работал с ней
        }else{
            String mess = "Country with name " + name +" is not found";
            req.setAttribute("message",mess);
        }
        requestDispatcher.forward(req,resp);//данный метод перенаправит пару запросв и ответ на указанную страницу

    }
}
