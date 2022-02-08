package com.form.footballform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/football")
public class FootballController {

    @GetMapping
    public String index() {
        return "Index";
    }
}
