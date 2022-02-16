package com.form.footballform.config;

import com.form.footballform.models.*;
import com.form.footballform.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TempConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            CountryCodeService countryCodeService,
            CountryService countryService,
            StateService stateService,
            CityService cityService,
            AddressService addressService,
            AgeGroupService ageGroupService,
            TeamService teamService,
            PositionService positionService,
            PlayerService playerService) {

        return args -> {

            //Initialization
            Country country  = countryService.saveCountry(new Country("India"));
            countryService.saveCountry(new Country("Sri Lanka"));
            countryService.saveCountry(new Country("Australia"));
            countryService.saveCountry(new Country("Afghanistan"));
            countryService.saveCountry(new Country("China"));

            CountryCode countryCode = countryCodeService.saveCountryCode(new CountryCode("+91", country));
            stateService.saveState(new State("Punjab", country));

            State state = stateService.saveState(new State("Haryana", country));
            stateService.saveState(new State("Uttarakhand", country));
            stateService.saveState(new State("Mumbai", country));

            City city = cityService.saveCity(new City("Rewari", state));

            cityService.saveCity(new City("Kharar", state));
            cityService.saveCity(new City("Sector 120", state));

            Address address = addressService.saveAddress(new Address("Phase 1", city, 110011));
            AgeGroup ageGroup = ageGroupService.saveAgeGroup(new AgeGroup("25-30"));

            Team desiredTeam = teamService.saveTeam(new Team("Chelsea"));
            teamService.saveTeam(new Team("Manchester United"));
            teamService.saveTeam(new Team("Liverpool"));
            teamService.saveTeam(new Team("Barcelona"));

            List<Position> desiredPosition = List.of(
                    positionService.savePosition(new Position("Goal Keeper")),
                    positionService.savePosition(new Position("Offensive")),
                    positionService.savePosition(new Position("Defensive")),
                    positionService.savePosition(new Position("Receiver"))
            );

            Player player = new Player(
                    "sonu",
                    "Sonu",
                    "Kumar",
                    countryCode,
                    "9898989898",
                    "sonu@gmail.com",
                    ageGroup,
                    address,
                    desiredTeam,
                    desiredPosition
            );
            playerService.savePlayer(player);
        };
    }
}
