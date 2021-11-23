package com.task.football.manager.service;

import com.task.football.manager.model.Player;
import com.task.football.manager.repository.PlayerRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getById(Long id) {
        return playerRepository.getById(id);
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    public void delete(Long id) {
        playerRepository.delete(playerRepository.getById(id));
    }

}
