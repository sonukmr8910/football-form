package com.form.footballform.service;

import com.form.footballform.models.*;
import com.form.footballform.models.request.PlayerRequest;
import com.form.footballform.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final CityService cityService;
    private final TeamService teamService;
    private final PositionService positionService;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, CityService cityService, TeamService teamService, PositionService positionService) {
        this.playerRepository = playerRepository;
        this.cityService = cityService;
        this.teamService = teamService;
        this.positionService = positionService;
    }

    public Optional<Player> getPlayer(Long id) {
        return playerRepository.getPlayerById(id);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player getPlayer(PlayerRequest playerRequest) {
        City city = cityService.getCity(playerRequest.getCity());
        Address playerAddress = new Address(playerRequest.getAddress(), city, playerRequest.getPinCode());

        Team playerDesiredTeam = teamService.getTeam(playerRequest.getDesiredTeam());
        List<Position> playerDesiredPositions = new ArrayList<>();
        for(Long positionIds : playerRequest.getDesiredPositions()) {
            playerDesiredPositions.add(positionService.getPosition(positionIds));
        }

        return new Player(
                playerRequest.getUserName(),
                playerRequest.getFirstName(),
                playerRequest.getLastName(),
                playerRequest.getPhoneNumber(),
                playerRequest.getEmail(),
                playerAddress,
                playerDesiredTeam,
                playerDesiredPositions
        );
    }

    public Player savePlayer(Long id, String username, String firstName, String lastName, String phoneNumber, String email, Address address, Team desiredTeam, List<Position> desiredPositions) {
        Player player = new Player(id, username, firstName, lastName, phoneNumber, email, address, desiredTeam, desiredPositions);
        return playerRepository.save(player);
    }

    public Player savePlayer(String username, String firstName, String lastName, String phoneNumber, String email, Address address, Team desiredTeam, List<Position> desiredPositions) {
        return savePlayer(null, username, firstName, lastName, phoneNumber, email, address, desiredTeam, desiredPositions);
    }
}
