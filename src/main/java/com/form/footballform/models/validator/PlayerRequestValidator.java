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
    private final CountryCodeService countryCodeService;
    private final AgeGroupService ageGroupService;
    private final TeamService teamService;
    private final PositionService positionService;

    @Autowired
    public PlayerRequestValidator(PlayerService playerService, CityService cityService, StateService stateService, CountryService countryService, CountryCodeService countryCodeService, AgeGroupService ageGroupService, TeamService teamService, PositionService positionService) {
        this.playerService = playerService;
        this.cityService = cityService;
        this.stateService = stateService;
        this.countryService = countryService;
        this.countryCodeService = countryCodeService;
        this.ageGroupService = ageGroupService;
        this.teamService = teamService;
        this.positionService = positionService;
    }

    @Override
    public boolean isUsernameValid() {
        System.out.println("checking username");
        if (request.getUserName() == null) return false;
        String userName = request.getUserName().trim();
        return !userName.isEmpty() &&
                userName.length() < 255 &&
                userName.matches("[A-Za-z0-9]+");
    }

    public boolean isUserNameAlreadyRegistered() {
        System.out.println("checking username existence");
        return isUsernameValid() && playerService.isUserNameAlreadyRegistered(request.getUserName());
    }

    @Override
    public boolean isFirstNameValid() {
        System.out.println("checking first name");
        if (request.getFirstName() == null) return false;
        String firstName = request.getFirstName().trim();
        return !firstName.isEmpty() &&
                firstName.length() < 255 &&
                firstName.matches("[A-Za-z]+");
    }

    @Override
    public boolean isLastNameValid() {
        System.out.println("checking last name");
        if (request.getLastName() == null) return false;
        String lastName = request.getLastName().trim();
        return !lastName.isEmpty() &&
                lastName.length() < 255 &&
                lastName.matches("[A-Za-z]+");
    }

    @Override
    public boolean isCountryCodeValid() {
        System.out.println("checking country code");
        if(request.getCountryCode() == null) return false;
        return countryCodeService.getCountryCode(request.getCountryCode()).isPresent();
    }

    @Override
    public boolean isPhoneNumberValid() {
        System.out.println("checking phone number");
        if (request.getPhoneNumber() == null) return false;
        String phoneNumber = request.getPhoneNumber();
        System.out.println(phoneNumber);
        return !phoneNumber.isEmpty() &&
                phoneNumber.length() < 15 &&
                phoneNumber.matches("[0-9]+");
    }

    @Override
    public boolean isEmailValid() {
        System.out.println("checking email validation");
        if (request.getEmail() == null) return false;
        String email = request.getEmail();
        return !email.isEmpty() &&
                email.length() < 255 &&
                email.matches("^(.+)@(\\S+)$");
    }

    public boolean isEmailAlreadyTaken() {
        System.out.println("checking email existence");
        return isEmailValid() && playerService.isEmailAlreadyTaken(request.getEmail());
    }

    @Override
    public boolean isAgeGroupValid() {
        System.out.println("checking age group");
        if(request.getAgeGroup() == null) return false;
        return ageGroupService.getAgeGroup(request.getAgeGroup()).isPresent();
    }

    @Override
    public boolean isAddressValid() {
        System.out.println("checking address");
        if (request.getAddress() == null) return false;
        String addr = request.getAddress();
        return !addr.isEmpty() &&
                addr.length() < 255 &&
                addr.matches("[A-Za-z0-9 #\\r\\n]+");
    }

    @Override
    public boolean isCompleteAddressValid() {
        System.out.println("checking complete address");
        return isCountryValid() && isStateValid() && isCityValid();
    }

    @Override
    public boolean isCityValid() {
        System.out.println("checking city");
        if (request.getCity() == null) return false;
        return cityService.getCity(request.getCity()).isPresent();
    }

    @Override
    public boolean isStateValid() {
        System.out.println("checking state");
        if (request.getState() == null) return false;
        return stateService.getState(request.getState()).isPresent();
    }

    @Override
    public boolean isCountryValid() {
        System.out.println("checking country");
        if (request.getCountry() == null) return false;
        return countryService.getCountry(request.getCountry()).isPresent();
    }

    @Override
    public boolean isPinCodeValid() {
        System.out.println("checking pincode");
        return request.getPinCode() >= 100000 || request.getPinCode() <= 999999;
    }

    @Override
    public boolean isDesiredTeamValid() {
        System.out.println("checking desired team");
        if (request.getDesiredTeam() == null) return false;
        return teamService.getTeam(request.getDesiredTeam()).isPresent();
    }

    @Override
    public boolean isDesiredPositionValid() {
        System.out.println("checking desired positions");
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
                isCountryCodeValid() &&
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
