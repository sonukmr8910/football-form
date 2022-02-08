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

    public boolean saveState(State state) {
        stateRepository.save(state);
        return true;
    }

    public boolean saveState(Long id, String name, Country country) {
        State state = new State(id, name, country);
        stateRepository.save(state);
        return true;
    }

    public boolean saveState(String name, Country country) {
        return saveState(null, name, country);
    }
}
