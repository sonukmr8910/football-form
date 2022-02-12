package com.form.footballform.service;

import com.form.footballform.models.Address;
import com.form.footballform.models.Player;
import com.form.footballform.models.Position;
import com.form.footballform.models.Team;
import com.form.footballform.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Optional<Player> getPlayer(Long id) {
        return playerRepository.getPlayerById(id);
    }

    public boolean isUserNameAlreadyRegistered(String userName) {
        return playerRepository.existsByUserName(userName);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player savePlayer(Long id, String username, String firstName, String lastName, String phoneNumber, String email, Address address, Team desiredTeam, List<Position> desiredPositions) {
        Player player = new Player(id, username, firstName, lastName, phoneNumber, email, address, desiredTeam, desiredPositions);
        return playerRepository.save(player);
    }

    public Player savePlayer(String username, String firstName, String lastName, String phoneNumber, String email, Address address, Team desiredTeam, List<Position> desiredPositions) {
        return savePlayer(null, username, firstName, lastName, phoneNumber, email, address, desiredTeam, desiredPositions);
    }
}
