package com.form.footballform.controller;

import com.form.footballform.models.Player;
import com.form.footballform.models.Response;
import com.form.footballform.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/football")
public class FootballController {
    private final PlayerService playerService;

    @Autowired
    public FootballController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Response<Player>> getPlayer(@PathVariable("id") Long id) {
        final Response<Player> response;
        final Player player = playerService.getPlayer(id);

        if (player != null) {
            response = new Response.ResponseBuilder<Player>()
                    .setHttpStatusCode(HttpStatus.OK.value())
                    .setData(player)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        String errorMessage = String.format("User with id %d not found", id);
        response = new Response.ResponseBuilder<Player>()
                .setHttpStatusCode(HttpStatus.NOT_FOUND.value())
                .setErrorMessage(errorMessage)
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}