package com.form.footballform.service;

import com.form.footballform.models.Position;
import com.form.footballform.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Optional<Position> getPosition(Long id) {
        return positionRepository.getPositionById(id);
    }

    public Position savePosition(Position position) {
        return savePosition(position.getId(), position.getName());
    }

    public Position savePosition(Long id, String name) {
        Position position = new Position(id, name);
        return positionRepository.save(position);
    }

    public Position savePosition(String name) {
        return savePosition(null, name);
    }
}
