package com.form.footballform.service;

import com.form.footballform.models.Country;
import com.form.footballform.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountry(Long id) {
        return countryRepository.getCountryById(id);
    }

    public Country saveCountry(Country country) {
        return saveCountry(country.getId(), country.getName());
    }
    
    public Country saveCountry(Long id, String name) {
        Country country = new Country(id, name);
        return countryRepository.save(country);
    }

    public Country saveCountry(String name) {
        return saveCountry(null, name);
    }
}
