package com.form.footballform.controller;

import com.form.footballform.models.City;
import com.form.footballform.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/city")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("{stateId}")
    public List<City> getCitiesByStateId(@PathVariable("stateId") String stateId) {
        try {
            long stateID = Long.parseLong(stateId);
            return cityService.getCitiesByStateId(stateID);
        }
        catch (NumberFormatException e) {
            return new ArrayList<>();
        }
    }
}
