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
            Country country = countryService.saveCountry(new Country("India"));
            CountryCode countryCode = countryCodeService.saveCountryCode(new CountryCode("+91", country));
            State state = stateService.saveState(new State("Punjab", country));
            City city = cityService.saveCity(new City("Mohali", state));
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
                    "sonukmr8910",
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
