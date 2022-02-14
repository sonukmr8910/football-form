package com.form.footballform.controller;

import com.form.footballform.models.CountryCode;
import com.form.footballform.models.response.Response;
import com.form.footballform.service.CountryCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/countrycode")
public class CountryCodeController {
    private final CountryCodeService countryCodeService;

    @Autowired
    public CountryCodeController(CountryCodeService countryCodeService) {
        this.countryCodeService = countryCodeService;
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<Response<List<CountryCode>>> getAllCountries() {
        Response<List<CountryCode>> response = new Response.ResponseBuilder<List<CountryCode>>()
                .setHttpStatusCode(HttpStatus.OK.value())
                .setData(countryCodeService.getAllCountryCodes())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
