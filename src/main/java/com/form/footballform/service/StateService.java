package com.form.footballform.service;

import com.form.footballform.models.Country;
import com.form.footballform.models.State;
import com.form.footballform.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    private final StateRepository stateRepository;

    @Autowired
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public Optional<State> getState(Long id) {
        return stateRepository.getStateById(id);
    }

    public List<State> getStatesByCountryId(Long countryId) {
        return stateRepository.getStatesByCountryId(countryId);
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
