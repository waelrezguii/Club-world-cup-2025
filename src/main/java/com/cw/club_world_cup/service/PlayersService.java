package com.cw.club_world_cup.service;

import com.cw.club_world_cup.model.Players;
import com.cw.club_world_cup.repository.PlayersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayersService {
    private final PlayersRepository playersRepository;
    @Autowired
    public PlayersService(PlayersRepository playersRepository){
        this.playersRepository = playersRepository ;
    }
    public List<Players> getPlayers(){
        return playersRepository.findAll();
    }
    public List<Players>getPlayersFromTeam(String teamname){
        return playersRepository.findByTeams_Teamname(teamname);
    }
    public List<Players>getPlayerByName(String searchText){
        return playersRepository.findAll().stream()
                .filter(players -> players.getPlayer().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Players>getPlayerByPos(String searchText){
        return playersRepository.findAll().stream()
                .filter(players -> players.getPos().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Players>getPlayerByNation(String searchText){
        return playersRepository.findAll().stream()
                .filter(players -> players.getNation().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Players>getPlayerByTeamAndPosition(String team, String pos){
        return playersRepository.findAll().stream()
                .filter(players -> team.equals(players.getTeams().getTeamname()) && pos.equals(players.getPos()))
                .collect(Collectors.toList());
    }
    public Players addPlayer(Players players){
        playersRepository.save(players);
    return players;
    }
    public Players updatePlayer(Players updatedPlayer){
        Optional<Players> existingPlayer = playersRepository.findByPlayer(updatedPlayer.getPlayer());
        if (existingPlayer.isPresent()){
            Players playerToUpdate = existingPlayer.get();
            playerToUpdate.setPlayer(updatedPlayer.getPlayer());
            playerToUpdate.setValue(updatedPlayer.getValue());
            playerToUpdate.setTeams(updatedPlayer.getTeams());
            playersRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }
    @Transactional
    public void deletePlayer(String player){

        playersRepository.deleteByPlayer(player);
}
}
