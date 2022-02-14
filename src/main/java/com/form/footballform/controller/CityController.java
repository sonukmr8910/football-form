package com.form.footballform.controller;

import com.form.footballform.models.City;
import com.form.footballform.models.response.Response;
import com.form.footballform.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @CrossOrigin
    @GetMapping(path = "api/v1/cities/{stateId}")
    public ResponseEntity<Response<List<City>>> getCitiesByStateId(@PathVariable("stateId") String stateId) {
        try {
            long stateID = Long.parseLong(stateId);
            Response<List<City>> response = new Response.ResponseBuilder<List<City>>()
                    .setHttpStatusCode(HttpStatus.OK.value())
                    .setData(cityService.getCitiesByStateId(stateID))
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (NumberFormatException e) {
            return new ResponseEntity<>(new Response.ResponseBuilder<List<City>>()
                    .setHttpStatusCode(HttpStatus.BAD_REQUEST.value())
                    .setErrorMessage("Invalid State Id")
                    .build(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
