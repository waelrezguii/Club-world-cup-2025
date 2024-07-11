package com.cw.club_world_cup.repository;

import com.cw.club_world_cup.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, String> {
}
