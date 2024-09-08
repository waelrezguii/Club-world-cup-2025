package com.cw.club_world_cup.controller;

import com.cw.club_world_cup.model.Players;
import com.cw.club_world_cup.model.Teams;
import com.cw.club_world_cup.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/players")
@CrossOrigin(origins = "https://club-world-cup-2025.vercel.app")

public class PlayersController {
private final PlayersService playersService;
@Autowired
    public PlayersController(PlayersService playersService){
    this.playersService=playersService;
}

@GetMapping
    public List<Players> getPlayers(@RequestParam(required = false)String name,  @RequestParam(required = false)String team,@RequestParam(required = false)String pos,@RequestParam(required = false) String nation){
if(team!=null && pos!=null){
    return playersService.getPlayerByTeamAndPosition(team,pos);
} else if (team!=null) {
    return playersService.getPlayersFromTeam(team);
}else if (name!=null) {
    return playersService.getPlayerByName(name);
}else if(pos != null){
    return playersService.getPlayerByPos(pos);
} else if (nation!=null) {
    return playersService.getPlayerByNation(nation);
}else {
    return playersService.getPlayers();
}
}
    @CrossOrigin(origins = "https://club-world-cup-2025.vercel.app")

@PostMapping
    public ResponseEntity<Players>addPlayer(@RequestBody Players players){
    Players createdPlayer = playersService.addPlayer(players);
    return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
}
    @CrossOrigin(origins = "https://club-world-cup-2025.vercel.app")

@PutMapping
    public ResponseEntity<Players> updatePlayer(@RequestBody Players players){
Players resultPlayer = playersService.updatePlayer(players);
if(resultPlayer != null){
    return new ResponseEntity<>(players,HttpStatus.OK);
}else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
    @CrossOrigin(origins = "https://club-world-cup-2025.vercel.app")

@DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName){
    playersService.deletePlayer(playerName);
return new ResponseEntity<>("Player deleted successfully",HttpStatus.OK);
}
}
