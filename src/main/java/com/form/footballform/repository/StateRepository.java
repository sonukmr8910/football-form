package com.form.footballform.repository;

import com.form.footballform.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    State getStateById(Long id);
}
