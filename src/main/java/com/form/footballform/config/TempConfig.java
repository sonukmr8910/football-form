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
            Country countryIndia  = countryService.saveCountry(new Country("India"));
            Country countrySriLanka = countryService.saveCountry(new Country("Sri Lanka"));
            Country countryAustralia = countryService.saveCountry(new Country("Australia"));
            Country countryAfghanistan = countryService.saveCountry(new Country("Afghanistan"));
            Country countryChina = countryService.saveCountry(new Country("China"));

            CountryCode countryCode = countryCodeService.saveCountryCode(new CountryCode("+91", countryIndia));
            countryCodeService.saveCountryCode(new CountryCode("+91", countrySriLanka));
            countryCodeService.saveCountryCode(new CountryCode("+101", countryAustralia));
            countryCodeService.saveCountryCode(new CountryCode("+82", countryAustralia));
            countryCodeService.saveCountryCode(new CountryCode("+64", countryAfghanistan));
            countryCodeService.saveCountryCode(new CountryCode("+75", countryChina));

            State stateHaryana = stateService.saveState(new State("Haryana", countryIndia));
            State statePunjab = stateService.saveState(new State("Punjab", countryIndia));
            State stateUttarakhand = stateService.saveState(new State("Uttarakhand", countryIndia));
            State stateKarnataka = stateService.saveState(new State("Karnataka", countryIndia));

            City city = cityService.saveCity(new City("Rewari", stateHaryana));
            cityService.saveCity(new City("Mandari", stateHaryana));
            cityService.saveCity(new City("Gopinath", stateHaryana));
            cityService.saveCity(new City("Shivnagar", stateHaryana));

            cityService.saveCity(new City("Kharar", statePunjab));
            cityService.saveCity(new City("Mohali", statePunjab));
            cityService.saveCity(new City("Daun", statePunjab));
            cityService.saveCity(new City("Zirkpur", statePunjab));

            cityService.saveCity(new City("Bageshwar", stateUttarakhand));
            cityService.saveCity(new City("Chamoli", stateUttarakhand));
            cityService.saveCity(new City("Dehradun", stateUttarakhand));
            cityService.saveCity(new City("Almora", stateUttarakhand));

            cityService.saveCity(new City("Bangalore", stateKarnataka));
            cityService.saveCity(new City("KR Puram", stateKarnataka));
            cityService.saveCity(new City("Bijnor", stateKarnataka));
            cityService.saveCity(new City("Vikaspur", stateKarnataka));

            Address address = addressService.saveAddress(new Address("Phase 1", city, "110011"));
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
