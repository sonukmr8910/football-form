package com.form.footballform.controller;

import com.form.footballform.models.State;
import com.form.footballform.models.response.Response;
import com.form.footballform.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateController {
    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @CrossOrigin
    @GetMapping(path = "api/v1/states/{countryId}")
    public ResponseEntity<Response<List<State>>> getStatesFor(@PathVariable("countryId") String countryId) {
        try {
            long countryID = Long.parseLong(countryId);
            Response<List<State>> response = new Response.ResponseBuilder<List<State>>()
                    .setHttpStatusCode(HttpStatus.OK.value())
                    .setData(stateService.getStatesByCountryId(countryID))
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(new Response.ResponseBuilder<List<State>>()
                    .setHttpStatusCode(HttpStatus.BAD_REQUEST.value())
                    .setErrorMessage("Invalid Country Id")
                    .build(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
