package com.example.controller;

import com.example.entity.City;
import com.example.entity.Country;
import com.example.dao.CountryDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    private final CountryDAO countryDAO;

    public CountryController(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    @GetMapping("/countries")
    public List<Country> countryList() {
        return countryDAO.findAll();
    }

    @GetMapping("/countries/{countryId}")
    public Country country(@PathVariable String countryId) {
        return countryDAO.findCountry(countryId);
    }

    @GetMapping("/countries/{countryId}/cities")
    public List<City> cityList(@PathVariable String countryId) {
        return countryDAO.findAllCitiesByCountry(countryId);
    }

    @GetMapping("/countries/{countryId}/cities/{cityId}")
    public City findCityByCountryId(@PathVariable String countryId, @PathVariable Long cityId) {
        return countryDAO.findCityByCountry(countryId, cityId);
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        return countryDAO.createCountry(country);
    }
}
