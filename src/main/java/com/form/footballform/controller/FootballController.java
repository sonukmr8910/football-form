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

    @PostMapping
    public ResponseEntity<Response<Player>> savePlayer(@RequestBody final PlayerRequest request) {

        validator.setPlayerRequest(request);
        if(validator.isUserNameAlreadyRegistered()) {
            Response<Player> response = new Response.ResponseBuilder<Player>()
                    .setHttpStatusCode(HttpStatus.BAD_REQUEST.value())
                    .setErrorMessage("Username is already registered")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if(!validator.isValid()){
            Response<Player> response = new Response.ResponseBuilder<Player>()
                    .setHttpStatusCode(HttpStatus.BAD_REQUEST.value())
                    .setErrorMessage("Data is not valid")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        Player savedPlayer = playerService.savePlayer(request);
        if(savedPlayer == null) {
            Response<Player> response = new Response.ResponseBuilder<Player>()
                    .setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .setErrorMessage("There was a problem in saving user data")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Response<Player> response = new Response.ResponseBuilder<Player>()
                .setHttpStatusCode(HttpStatus.OK.value())
                .setMessage("Data saved successfully")
                .setData(savedPlayer)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}