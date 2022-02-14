package com.form.footballform.controller;

import com.form.footballform.models.*;
import com.form.footballform.models.request.PlayerRequest;
import com.form.footballform.models.response.Response;
import com.form.footballform.models.validator.PlayerRequestValidator;
import com.form.footballform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/football")
public class FootballController {
    private final PlayerService playerService;
    private final PlayerRequestValidator validator;

    @Autowired
    public FootballController(PlayerService playerService, PlayerRequestValidator validator) {
        this.playerService = playerService;
        this.validator = validator;
    }

    @CrossOrigin
    @GetMapping("{userid}")
    public ResponseEntity<Response<Player>> getPlayer(@PathVariable("userid") String userid) {
        Long id;
        final Response<Player> response;

        try {
            id = Long.parseLong(userid);
        } catch (NumberFormatException e) {
            response = new Response.ResponseBuilder<Player>()
                    .setHttpStatusCode(HttpStatus.BAD_REQUEST.value())
                    .setErrorMessage("Invalid User Id")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        final Optional<Player> player = playerService.getPlayer(id);

        if (player.isEmpty()) {
            String errorMessage = String.format("User with id %d not found", id);
            response = new Response.ResponseBuilder<Player>()
                    .setHttpStatusCode(HttpStatus.NOT_FOUND.value())
                    .setErrorMessage(errorMessage)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response = new Response.ResponseBuilder<Player>()
                .setHttpStatusCode(HttpStatus.OK.value())
                .setData(player.get())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Response<Player>> savePlayer(@RequestBody final PlayerRequest request) {

        validator.setPlayerRequest(request);
        Response.ResponseBuilder<Player> responseBuilder = new Response.ResponseBuilder<>();

        if (validator.isUserNameAlreadyRegistered()) {
            responseBuilder
                    .setHttpStatusCode(HttpStatus.BAD_REQUEST.value())
                    .setErrorMessage("Username is already registered");
            return new ResponseEntity<>(responseBuilder.build(), HttpStatus.BAD_REQUEST);
        }

        if(validator.isEmailAlreadyTaken()) {
            responseBuilder
                    .setHttpStatusCode(HttpStatus.BAD_REQUEST.value())
                    .setErrorMessage("Email is already taken");
            return new ResponseEntity<>(responseBuilder.build(), HttpStatus.BAD_REQUEST);
        }

        if (!validator.isValid()) {
            System.out.println("Data is not valid");
            System.out.println(request);
            responseBuilder
                    .setHttpStatusCode(HttpStatus.BAD_REQUEST.value())
                    .setErrorMessage("Data is not valid");
            return new ResponseEntity<>(responseBuilder.build(), HttpStatus.OK);
        }
        System.out.println("Reach");
        Player savedPlayer = playerService.savePlayer(request);
        if (savedPlayer == null) {
            responseBuilder
                    .setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .setErrorMessage("There was a problem in saving user data");
            return new ResponseEntity<>(responseBuilder.build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Response<Player> response = new Response.ResponseBuilder<Player>()
                .setHttpStatusCode(HttpStatus.OK.value())
                .setMessage("Data saved successfully")
                .setData(savedPlayer)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}