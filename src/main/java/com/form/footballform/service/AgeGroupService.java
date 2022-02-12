package com.form.footballform.service;

import com.form.footballform.models.AgeGroup;
import com.form.footballform.repository.AgeGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AgeGroupService {
    private final AgeGroupRepository ageGroupRepository;

    @Autowired
    public AgeGroupService(AgeGroupRepository ageGroupRepository) {
        this.ageGroupRepository = ageGroupRepository;
    }

    Optional<AgeGroup> getAgeGroup(Long id) {
        return ageGroupRepository.getAgeGroupById(id);
    }

    public AgeGroup saveAgeGroup(Long id, String name) {
        AgeGroup ageGroup = new AgeGroup(id, name);
        return ageGroupRepository.save(ageGroup);
    }

    public AgeGroup saveAgeGroup(AgeGroup ageGroup) {
        return saveAgeGroup(ageGroup.getId(), ageGroup.getName());
    }

    public AgeGroup saveAgeGroup(String name) {
        return saveAgeGroup(null, name);
    }
}
