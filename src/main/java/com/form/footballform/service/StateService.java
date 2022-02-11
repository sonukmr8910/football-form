package com.form.footballform.service;

import com.form.footballform.models.Country;
import com.form.footballform.models.State;
import com.form.footballform.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {
    private final StateRepository stateRepository;

    @Autowired
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public State getState(Long id) {
        return stateRepository.getById(id);
    }

    public State saveState(State state) {
        return saveState(state.getId(), state.getName(), state.getCountry());
    }

    public State saveState(Long id, String name, Country country) {
        State state = new State(id, name, country);
        return stateRepository.save(state);
    }

    public State saveState(String name, Country country) {
        return saveState(null, name, country);
    }
}
