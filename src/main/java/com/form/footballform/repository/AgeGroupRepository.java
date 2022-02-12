package com.form.footballform.repository;

import com.form.footballform.models.AgeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgeGroupRepository extends JpaRepository<AgeGroup, Long> {
    Optional<AgeGroup> getAgeGroupById(Long id);
}
