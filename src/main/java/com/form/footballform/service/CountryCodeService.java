package com.form.footballform.service;

import com.form.footballform.models.CountryCode;
import com.form.footballform.repository.CountryCodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryCodeService {
    private CountryCodeRepository countryCodeRepository;

    public List<CountryCode> getAllCountryCodes() {
        return countryCodeRepository.findAll();
    }
}
