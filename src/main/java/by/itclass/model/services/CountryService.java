package by.itclass.model.services;

import by.itclass.model.dao.CountryDao;
import by.itclass.model.db.DbInMemory;
import by.itclass.model.entities.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CountryService {
    private CountryDao countryDao;

    public CountryService() {
        countryDao = new CountryDao();
    }

    public List<Country> getCountriesByCriteria(Map<String,String[]>params){
        List<Country>countries = new ArrayList<>();
        String criteria = params.get("criteria")[0];//достаем первый параметр из мапы критерии
        switch(criteria){
            case "name":{
                String name = params.get("name")[0];
                //countries.add(DbInMemory.findCountryByName(name));
                countries.add(countryDao.findByName(name));
                countries = countries.stream().filter(Objects::nonNull).collect(Collectors.toList());
                break;
            }
            case"id":{
                String fromId = params.get("fromId")[0];
                String toId = params.get("toId")[0];
                int from = Integer.parseInt(fromId);
                int to = Integer.parseInt(toId);
                //countries= DbInMemory.findCountriesById(from,to);
                countries = countryDao.findCountryByIds(from,to);
                break;
            }
            default:break;
        }
        return countries;
    }
}
