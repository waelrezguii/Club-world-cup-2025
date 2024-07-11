package com.cw.club_world_cup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="teams")
public class Teams {
@Id
private String idt;
@Column(name="teamname")
    private String teamname;
@Column(name="image")
    private  String image;

    public String getIdt() {
        return idt;
    }

    public void setIdt(String idt) {
        this.idt = idt;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "idt='" + idt + '\'' +
                ", teamname='" + teamname + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
