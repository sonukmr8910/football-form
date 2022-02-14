package com.form.footballform.controller;

import com.form.footballform.models.AgeGroup;
import com.form.footballform.models.response.Response;
import com.form.footballform.service.AgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgeGroupController {
    private final AgeGroupService ageGroupService;

    @Autowired
    public AgeGroupController(AgeGroupService ageGroupService) {
        this.ageGroupService = ageGroupService;
    }

    @CrossOrigin
    @GetMapping(path = "api/v1/agegroup")
    public ResponseEntity<Response<List<AgeGroup>>> getAllAgeGroups() {
        Response<List<AgeGroup>> response = new Response.ResponseBuilder<List<AgeGroup>>()
                .setHttpStatusCode(HttpStatus.OK.value())
                .setData(ageGroupService.getAllAgeGroups())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
