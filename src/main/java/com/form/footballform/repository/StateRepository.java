package com.form.footballform.repository;

import com.form.footballform.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    Optional<State> getStateById(Long id);
    List<State> getStatesByCountryId(Long countryId);
}
