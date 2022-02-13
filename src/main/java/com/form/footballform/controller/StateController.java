package com.form.footballform.controller;

import com.form.footballform.models.State;
import com.form.footballform.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/state")
public class StateController {
    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("{countryId}")
    public List<State> getStatesFor(@PathVariable("countryId") String countryId) {
        try {
            long countryID = Long.parseLong(countryId);
            return stateService.getStatesByCountryId(countryID);
        } catch (NumberFormatException e) {
            return new ArrayList<>();
        }
    }
}
