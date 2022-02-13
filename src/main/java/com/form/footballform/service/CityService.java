package com.form.footballform.service;

import com.form.footballform.models.City;
import com.form.footballform.models.State;
import com.form.footballform.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Optional<City> getCity(Long id) {
        return cityRepository.getCityById(id);
    }

    public List<City> getCitiesByStateId(Long stateId) {
        return cityRepository.getCitysByStateId(stateId);
    }

    public City saveCity(City city) {
        return saveCity(city.getId(), city.getName(), city.getState());
    }

    public City saveCity(Long id, String name, State state) {
        City city = new City(id, name, state);
        return cityRepository.save(city);
    }

    public City saveCity(String name, State state) {
        return saveCity(null, name, state);
    }
}
