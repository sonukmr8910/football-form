package com.form.footballform.models.validator;

import com.form.footballform.models.request.PlayerRequest;
import com.form.footballform.models.validator.abs.PlayerRequestValidatorAbs;
import com.form.footballform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerRequestValidator extends PlayerRequestValidatorAbs {
    private PlayerRequest request;
    private final PlayerService playerService;
    private final CityService cityService;
    private final StateService stateService;
    private final CountryService countryService;
    private final AgeGroupService ageGroupService;
    private final TeamService teamService;
    private final PositionService positionService;

    @Autowired
    public PlayerRequestValidator(PlayerService playerService, CityService cityService, StateService stateService, CountryService countryService, AgeGroupService ageGroupService, TeamService teamService, PositionService positionService) {
        this.playerService = playerService;
        this.cityService = cityService;
        this.stateService = stateService;
        this.countryService = countryService;
        this.ageGroupService = ageGroupService;
        this.teamService = teamService;
        this.positionService = positionService;
    }

    @Override
    public boolean isUsernameValid() {
        if (request.getUserName() == null) return false;
        String userName = request.getUserName().trim();
        return !userName.isEmpty() &&
                userName.length() < 255 &&
                userName.matches("[A-Za-z0-9]+");
    }

    public boolean isUserNameAlreadyRegistered() {
        String userName = request.getUserName();
        return isUsernameValid() && playerService.isUserNameAlreadyRegistered(userName);
    }

    @Override
    public boolean isFirstNameValid() {
        if (request.getFirstName() == null) return false;
        String firstName = request.getFirstName().trim();
        return !firstName.isEmpty() &&
                firstName.length() < 255 &&
                firstName.matches("[A-Za-z]+");
    }

    @Override
    public boolean isLastNameValid() {
        if (request.getLastName() == null) return false;
        String lastName = request.getLastName().trim();
        return !lastName.isEmpty() &&
                lastName.length() < 255 &&
                lastName.matches("[A-Za-z]+");
    }

    @Override
    public boolean isPhoneNumberValid() {
        if (request.getPhoneNumber() == null) return false;
        String phoneNumber = request.getPhoneNumber();
        System.out.println(phoneNumber);
        return !phoneNumber.isEmpty() &&
                phoneNumber.length() < 15 &&
                phoneNumber.matches("[0-9]+");
    }

    @Override
    public boolean isEmailValid() {
        if (request.getEmail() == null) return false;
        String email = request.getEmail();
        return !email.isEmpty() &&
                email.length() < 255 &&
                email.matches("^(.+)@(\\S+)$");
    }

    @Override
    public boolean isAgeGroupValid() {
        if(request.getAgeGroup() == null) return false;
        return ageGroupService.getAgeGroup(request.getAgeGroup()).isPresent();
    }

    @Override
    public boolean isAddressValid() {
        if (request.getAddress() == null) return false;
        String addr = request.getAddress();
        return !addr.isEmpty() &&
                addr.length() < 255 &&
                addr.matches("[A-Za-z0-9 #]+");
    }

    @Override
    public boolean isCompleteAddressValid() {
        return isCountryValid() && isStateValid() && isCityValid();
    }

    @Override
    public boolean isCityValid() {
        if (request.getCity() == null) return false;
        return cityService.getCity(request.getCity()).isPresent();
    }

    @Override
    public boolean isStateValid() {
        if (request.getState() == null) return false;
        return stateService.getState(request.getState()).isPresent();
    }

    @Override
    public boolean isCountryValid() {
        if (request.getCountry() == null) return false;
        return countryService.getCountry(request.getCountry()).isPresent();
    }

    @Override
    public boolean isPinCodeValid() {
        return request.getPinCode() >= 100000 || request.getPinCode() <= 999999;
    }

    @Override
    public boolean isDesiredTeamValid() {
        if (request.getDesiredTeam() == null) return false;
        return teamService.getTeam(request.getDesiredTeam()).isPresent();
    }

    @Override
    public boolean isDesiredPositionValid() {
        List<Long> desiredPositions = request.getDesiredPositions();
        if (desiredPositions == null || desiredPositions.isEmpty()) return false;
        for (Long id : desiredPositions) {
            if (positionService.getPosition(id).isEmpty()) return false;
        }
        return true;
    }

    public void setPlayerRequest(PlayerRequest playerRequest) {
        this.request = playerRequest;
    }

    @Override
    public boolean isValid() {
        if (request == null)
            throw new RuntimeException("PlayerRequest is not set. Use setPlayer() to initialize PlayerRequest");
        return isUsernameValid() &&
                isFirstNameValid() &&
                isLastNameValid() &&
                isEmailValid() &&
                isPhoneNumberValid() &&
                isAgeGroupValid() &&
                isAddressValid() &&
                isCityValid() &&
                isStateValid() &&
                isCountryValid() &&
                isPinCodeValid() &&
                isCompleteAddressValid() &&
                isDesiredTeamValid() &&
                isDesiredPositionValid();
    }
}
