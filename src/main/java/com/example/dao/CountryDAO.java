package com.example.dao;

import com.example.entity.City;
import com.example.entity.Country;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CountryDAO {

    private static Map<String, Country> countryMap = new HashMap<>();

    static {
        initCountries();
    }

    private static void initCountries() {
        City uaCity1 = new City(100L, "Kyiv");
        City uaCity2 = new City(101L, "Lviv");
        City uaCity3 = new City(102L, "Odesa");
        City uaCity4 = new City(103L, "Kharkiv");
        City uaCity5 = new City(104L, "Ternolil");
        List<City> uaCities = Arrays.asList(uaCity1, uaCity2, uaCity3, uaCity4, uaCity5);
        Country ua = new Country("UA", "Ukraine", uaCities);

        City deCity1 = new City(200L, "Kiel");
        City deCity2 = new City(201L, "Hamburg");
        City deCity3 = new City(202L, "Frankfurt");
        City deCity4 = new City(203L, "Berlin");
        List<City> deCities = Arrays.asList(deCity1, deCity2, deCity3, deCity4);
        Country de = new Country("DE", "Germany", deCities);

        countryMap.put("UA", ua);
        countryMap.put("DE", de);
    }

    public Country getCountry(String id) {
        return countryMap.get(id);
    }

    public List<Country> findAll() {
        return new ArrayList<>(countryMap.values());
    }

    public List<City> findAllCitiesByCountry(String countryId) {
        return countryMap.get(countryId).getCities();
    }

    public City findCityByCountry(String countryId, Long cityId) {
        return countryMap.get(countryId).getCities().stream()
                .filter(city -> city.getId().equals(cityId))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
