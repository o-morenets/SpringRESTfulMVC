package com.example.service;

import com.example.dao.CountryDAO;
import com.example.entity.City;
import com.example.entity.Country;
import com.example.repository.CountryRepository;

import java.util.List;

public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryDAO countryDAO, CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getById(String countryId) {
        return countryRepository.findById(countryId).orElseThrow(RuntimeException::new);
    }

    public List<City> getAllCitiesByCountryId(String countryId) {
        return countryRepository.findAllCitiesByCountryId(countryId);
    }

    public City getCityByCountryId(String countryId, Long cityId) {
        return countryRepository.findCityByCountryId(countryId, cityId).orElseThrow(RuntimeException::new);
    }

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    public void deleteCountry(String countryId) {
        countryRepository.deleteById(countryId);
    }
}
