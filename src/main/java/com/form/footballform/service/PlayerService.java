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
    private final CountryCodeService countryCodeService;
    private final CountryService countryService;
    private final StateService stateService;
    private final CityService cityService;
    private final AddressService addressService;
    private final AgeGroupService ageGroupService;
    private final TeamService teamService;
    private final PositionService positionService;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, CountryCodeService countryCodeService, CountryService countryService, StateService stateService, CityService cityService, AddressService addressService, AgeGroupService ageGroupService, TeamService teamService, PositionService positionService) {
        this.playerRepository = playerRepository;
        this.countryCodeService = countryCodeService;
        this.countryService = countryService;
        this.stateService = stateService;
        this.cityService = cityService;
        this.addressService = addressService;
        this.ageGroupService = ageGroupService;
        this.teamService = teamService;
        this.positionService = positionService;
    }

    public Optional<Player> getPlayer(Long id) {
        return playerRepository.getPlayerById(id);
    }

    public Optional<Player> getPlayer(String userName) {
        return playerRepository.getPlayerByUserName(userName);
    }

    public boolean isUserNameAlreadyRegistered(String userName) {
        return playerRepository.existsByUserName(userName);
    }

    public boolean isEmailAlreadyTaken(String email) {
        return playerRepository.existsByEmail(email);
    }

    public Player savePlayer(final PlayerRequest request) {
        try {
            CountryCode countryCode = countryCodeService.getCountryCode(request.getCountryCode()).orElseThrow();
            AgeGroup ageGroup = ageGroupService.getAgeGroup(request.getAgeGroup()).orElseThrow();
            City city = cityService.getCity(request.getCity()).orElseThrow();
            Address address = addressService.saveAddress(new Address(request.getAddress(), city, request.getPinCode()));
            Team desiredTeam = teamService.getTeam(request.getDesiredTeam()).orElseThrow();

            List<Long> posIds = request.getDesiredPositions();
            List<Position> desiredPositions = new ArrayList<>();
            for (Long posId : posIds) {
                Optional<Position> position = positionService.getPosition(posId);
                position.ifPresent(desiredPositions::add);
            }

            Player player = new Player(
                    request.getUserName(),
                    request.getFirstName(),
                    request.getLastName(),
                    countryCode,
                    request.getPhoneNumber(),
                    request.getEmail(),
                    ageGroup,
                    address,
                    desiredTeam,
                    desiredPositions
            );

            return playerRepository.save(player);
        } catch (Exception e) {
            return null;
        }
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player savePlayer(Long id, String username, String firstName, String lastName, CountryCode countryCode, String phoneNumber, String email, AgeGroup ageGroup, Address address, Team desiredTeam, List<Position> desiredPositions) {
        Player player = new Player(id, username, firstName, lastName, countryCode, phoneNumber, email, ageGroup, address, desiredTeam, desiredPositions);
        return playerRepository.save(player);
    }

    public Player savePlayer(String username, String firstName, String lastName, CountryCode countryCode, String phoneNumber, String email, AgeGroup ageGroup, Address address, Team desiredTeam, List<Position> desiredPositions) {
        return savePlayer(null, username, firstName, lastName, countryCode, phoneNumber, email, ageGroup, address, desiredTeam, desiredPositions);
    }

    public Player updatePlayer(Player player, PlayerRequest request) {
        try {
            player.setFirstName(request.getFirstName());
            player.setLastName(request.getLastName());
            player.setCountryCode(countryCodeService.getCountryCode(request.getCountryCode()).get());
            player.setPhoneNumber(request.getPhoneNumber());
            player.setEmail(request.getEmail());
            player.setAgeGroup(ageGroupService.getAgeGroup(request.getAgeGroup()).get());
            player.setDesiredTeam(teamService.getTeam(request.getDesiredTeam()).get());

            List<Long> desiredPositionIds = request.getDesiredPositions();
            List<Position> desiredPositions = new ArrayList<>();
            for(Long positionId : desiredPositionIds) {
                desiredPositions.add(positionService.getPosition(positionId).get());
            }
            player.setDesiredPositions(desiredPositions);

            City city = cityService.getCity(request.getCity()).get();
            Address playerAddress = player.getAddress();
            playerAddress.setAddress(request.getAddress());
            playerAddress.setCity(city);

            if(request.getPinCode() != null)
                playerAddress.setPinCode(request.getPinCode());

            playerAddress = addressService.saveAddress(playerAddress);
            player.setAddress(playerAddress);

            return savePlayer(player);
        }
        catch (Exception e) {
            return null;
        }
    }
}
