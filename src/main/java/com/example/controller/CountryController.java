package com.example.controller;

import com.example.entity.City;
import com.example.entity.Country;
import com.example.dao.CountryDAO;
import com.example.service.CountryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    private final CountryServiceImpl countryServiceImpl;

    public CountryController(CountryDAO countryDAO, CountryServiceImpl countryServiceImpl) {
        this.countryServiceImpl = countryServiceImpl;
    }

    @GetMapping("/countries")
    public List<Country> countryList() {
        return countryServiceImpl.getAllCountries();
    }

    @GetMapping("/countries/{countryId}")
    public Country country(@PathVariable String countryId) {
        return countryServiceImpl.getById(countryId);
    }

    @GetMapping("/countries/{countryId}/cities")
    public List<City> cityList(@PathVariable String countryId) {
        return countryServiceImpl.getAllCitiesByCountryId(countryId);
    }

    @GetMapping("/countries/{countryId}/cities/{cityId}")
    public City findCityByCountryId(@PathVariable String countryId, @PathVariable Long cityId) {
        return countryServiceImpl.getCityByCountryId(countryId, cityId);
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        return countryServiceImpl.createCountry(country);
    }

    @DeleteMapping("/countries/{countryId}")
    public void deleteCountry(@PathVariable String countryId) {
        countryServiceImpl.deleteCountry(countryId);
    }
}
