package com.cw.club_world_cup.repository;

import com.cw.club_world_cup.model.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayersRepository extends JpaRepository<Players,String> {
    void deleteByPlayer(String player);
    Optional<Players> findByPlayer(String player);
    @Query("select p from Players p where p.teams.teamname=:teamname")
    List<Players>findByTeams_Teamname(@Param("teamname") String teamname);
}
