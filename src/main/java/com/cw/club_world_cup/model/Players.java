package com.cw.club_world_cup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="players")
public class Players {
@Id
private String player;
@Column(name="value")
    private String value;
@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
@JoinColumn(name = "idt")
private Teams teams;
@Column(name="pos")
private String pos;
@Column(name="nation")
private String nation;

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "Players{" +
                "player='" + player + '\'' +
                ", value='" + value + '\'' +
                ", teams=" + teams +
                ", pos='" + pos + '\'' +
                ", nation='" + nation + '\'' +
                '}';
    }
}
