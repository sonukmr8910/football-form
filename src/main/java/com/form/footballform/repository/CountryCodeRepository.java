package com.form.footballform.repository;

import com.form.footballform.models.CountryCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryCodeRepository extends JpaRepository<CountryCode, Long> {
    Optional<CountryCode> getCountryCodeById(Long id);
}
