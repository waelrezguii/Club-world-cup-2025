package com.cw.club_world_cup.service;

import com.cw.club_world_cup.model.Teams;
import com.cw.club_world_cup.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamsService {
    private final TeamsRepository teamsRepository;

    @Autowired
    public TeamsService(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    public List<Teams> getAllTeams() {
        return teamsRepository.findAll();
    }

    public Optional<Teams> getTeamById(String id) {
        return teamsRepository.findById(id);
    }

    public Teams addTeam(Teams team) {
        return teamsRepository.save(team);
    }

    public Teams updateTeam(Teams team) {
        return teamsRepository.save(team);
    }

    public void deleteTeam(String id) {
        teamsRepository.deleteById(id);
    }
}
