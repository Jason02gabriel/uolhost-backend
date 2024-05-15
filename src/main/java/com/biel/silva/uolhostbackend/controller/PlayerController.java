package com.biel.silva.uolhostbackend.controller;

import com.biel.silva.uolhostbackend.dto.PlayerDTO;
import com.biel.silva.uolhostbackend.model.Player;
import com.biel.silva.uolhostbackend.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getPlayer() {
        List<Player> players = playerService.getPlayer();
        return ResponseEntity.status(HttpStatus.OK).body(players);
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerDTO player) {
        Player newPlayer = playerService.createPlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
    }
}
