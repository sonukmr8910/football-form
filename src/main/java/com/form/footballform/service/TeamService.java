package com.form.footballform.service;

import com.form.footballform.models.Team;
import com.form.footballform.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team getTeam(Long id) {
        return teamRepository.getById(id);
    }

    public boolean saveTeam(Long id, String name) {
        Team team = new Team(id, name);
        teamRepository.save(team);
        return true;
    }

    public boolean saveTeam(String name) {
        return saveTeam(null, name);
    }
}
