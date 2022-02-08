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
            CountryService countryService,
            StateService stateService,
            CityService cityService,
            AddressService addressService,
            TeamService teamService,
            PositionService positionService,
            PlayerService playerService) {

        return args -> {
            Country country = new Country("India");
            countryService.saveCountry(country);
            State state = new State("Punjab", country);
            stateService.saveState(state);
            City city = new City("Mohali", state);
            cityService.saveCity(city);
            Address address = new Address("Phase 1", city, 110011);
            addressService.saveAddress(address);

            Team desiredTeam = new Team("Barcelona");
            teamService.saveTeam(desiredTeam);
            List<Position> desiredPosition = List.of(
                    new Position("Goal Keeper"),
                    new Position("Defender")
            );

            for(Position p : desiredPosition) {
                positionService.savePosition(p);
            }

            Player player = new Player(
                    "sonukmr8910",
                    "Sonu",
                    "Kumar",
                    "9898989898",
                    "sonu@gmail.com",
                    address,
                    desiredTeam,
                    desiredPosition
            );
            playerService.savePlayer(player);
        };
    }
}
