package com.form.footballform.service;

import com.form.footballform.models.City;
import com.form.footballform.models.State;
import com.form.footballform.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City getCity(Long id) {
        return cityRepository.getById(id);
    }

    public boolean saveCity(Long id, String name, State state) {
        City city = new City(id, name, state);
        cityRepository.save(city);
        return true;
    }

    public boolean saveCity(String name, State state) {
        return saveCity(null, name, state);
    }
}
