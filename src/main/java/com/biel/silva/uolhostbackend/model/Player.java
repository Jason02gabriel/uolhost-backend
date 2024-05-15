package com.biel.silva.uolhostbackend.model;

import com.biel.silva.uolhostbackend.dto.PlayerDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "players")
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    private String phoneNumber;
    private String codename;
    private GroupType groupType;

    public Player(PlayerDTO dto) {
        this.groupType = dto.groupType();
        this.email = dto.email();
        this.phoneNumber = dto.phoneNumber();
        this.name = dto.name();
    }
}
