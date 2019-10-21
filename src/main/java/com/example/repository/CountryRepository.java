package com.example.repository;

import com.example.entity.City;
import com.example.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<City> findAllCitiesByCountryId(String countryId);

    Optional<City> findCityByCountryId(String countryId, Long cityId);
}
