package com.form.footballform.controller;

import com.form.footballform.models.AgeGroup;
import com.form.footballform.service.AgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping(path = "api/v1/agegroup")
    public List<AgeGroup> getAllAgeGroups() {
        return ageGroupService.getAllAgeGroups();
    }
}
