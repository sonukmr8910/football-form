package com.form.footballform.controller;

import com.form.footballform.models.Country;
import com.form.footballform.models.response.Response;
import com.form.footballform.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/country")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<Response<List<Country>>> getAllCountries() {
        Response<List<Country>> response = new Response.ResponseBuilder<List<Country>>()
                .setHttpStatusCode(HttpStatus.OK.value())
                .setData(countryService.getAllCountries())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
