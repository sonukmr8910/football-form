package com.form.footballform.config;

import com.form.footballform.models.*;
import com.form.footballform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TempConfig {

    @Autowired
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
            country = countryService.saveCountry(country);
            State state = new State("Punjab", country);
            state = stateService.saveState(state);
            City city = new City("Mohali", state);
            city = cityService.saveCity(city);
            Address address = new Address("Phase 1", city, 110011);
            address = addressService.saveAddress(address);

            Team desiredTeam = new Team("Barcelona");
            desiredTeam = teamService.saveTeam(desiredTeam);
            List<Position> desiredPosition = List.of(
                    positionService.savePosition(new Position("Goal Keeper")),
                    positionService.savePosition(new Position("Defender"))
            );

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
