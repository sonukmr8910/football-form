package com.form.footballform.service;

import com.form.footballform.models.Team;
import com.form.footballform.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Optional<Team> getTeam(Long id) {
        return teamRepository.getTeamById(id);
    }

    public Team saveTeam(Team team) {
        return saveTeam(team.getId(), team.getName());
    }

    public Team saveTeam(Long id, String name) {
        Team team = new Team(id, name);
        return teamRepository.save(team);
    }

    public Team saveTeam(String name) {
        return saveTeam(null, name);
    }
}
