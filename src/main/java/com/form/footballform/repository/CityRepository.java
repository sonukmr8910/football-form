package com.form.footballform.repository;

import com.form.footballform.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> getCityById(Long id);
    List<City> getCitysByStateId(Long stateId);
}
