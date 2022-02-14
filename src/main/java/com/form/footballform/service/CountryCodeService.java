package com.form.footballform.service;

import com.form.footballform.models.Country;
import com.form.footballform.models.CountryCode;
import com.form.footballform.repository.CountryCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryCodeService {
    private final CountryCodeRepository countryCodeRepository;

    @Autowired
    public CountryCodeService(CountryCodeRepository countryCodeRepository) {
        this.countryCodeRepository = countryCodeRepository;
    }

    public List<CountryCode> getAllCountryCodes() {
        return countryCodeRepository.findAll();
    }

    public Optional<CountryCode> getCountryCode(Long id) {
        return countryCodeRepository.getCountryCodeById(id);
    }

    public CountryCode saveCountryCode(CountryCode countryCode) {
        return saveCountryCode(countryCode.getId(), countryCode.getCode(), countryCode.getCountry());
    }

    public CountryCode saveCountryCode(Long id, String code, Country country) {
        CountryCode countryCode = new CountryCode(id, code, country);
        return countryCodeRepository.save(countryCode);
    }

    public CountryCode saveCountryCode(String code, Country country) {
        return saveCountryCode(null, code, country);
    }
}
