package com.cw.club_world_cup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class Users {
    @Id
    private String email;
    @Column(name="mdp")
    private String mdp;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.mdp = passwordEncoder.encode(this.mdp);
    }

    public boolean verifyPassword(String password, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password, this.mdp);
    }
    @Override
    public String toString() {
        return "Users{" +
                "email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
