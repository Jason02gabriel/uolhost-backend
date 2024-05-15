package com.biel.silva.uolhostbackend.service;

import com.biel.silva.uolhostbackend.dto.PlayerDTO;
import com.biel.silva.uolhostbackend.exception.EmptyEmailFieldException;
import com.biel.silva.uolhostbackend.exception.EmptyNameFieldException;
import com.biel.silva.uolhostbackend.infra.CodenameHandler;
import com.biel.silva.uolhostbackend.model.GroupType;
import com.biel.silva.uolhostbackend.model.Player;
import com.biel.silva.uolhostbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<Player> getPlayer() {
        return repository.findAll();
    }

    @Autowired
    private CodenameHandler codenameHandler;


    public Player createPlayer(PlayerDTO player) {
        Player newPlayer = new Player(player);
        String codename = getCodename(player.groupType());
        newPlayer.setCodename(codename);

        if (newPlayer.getName().isEmpty()) {
            throw new EmptyNameFieldException("PLEASE FILL IN THE NAME FIELD");
        }

        if (newPlayer.getEmail().isEmpty()) {
            throw new EmptyEmailFieldException("PLEASE FILL IN THE EMAIL FIELD");
        }

        return repository.save(newPlayer);
    }

    private String getCodename(GroupType groupType) {
        return codenameHandler.findCodename(groupType);
    }
}
