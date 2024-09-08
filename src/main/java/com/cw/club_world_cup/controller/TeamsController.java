package com.cw.club_world_cup.controller;

import com.cw.club_world_cup.model.Teams;
import com.cw.club_world_cup.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamsController {
    private final TeamsService teamsService;

    @Autowired
    public TeamsController(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @GetMapping
    public ResponseEntity<List<Teams>> getAllTeams() {
        List<Teams> teams = teamsService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teams> getTeamById(@PathVariable String id) {
        Optional<Teams> team = teamsService.getTeamById(id);
        return team.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Teams> addTeam(@RequestBody Teams team) {
        Teams createdTeam = teamsService.addTeam(team);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teams> updateTeam(@PathVariable String id, @RequestBody Teams team) {
        if (!teamsService.getTeamById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        team.setIdt(id);
        Teams updatedTeam = teamsService.updateTeam(team);
        return ResponseEntity.ok(updatedTeam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable String id) {
        teamsService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}
