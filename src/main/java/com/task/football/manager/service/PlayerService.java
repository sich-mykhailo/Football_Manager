package com.task.football.manager.service;

import com.task.football.manager.model.Player;
import java.util.List;

public interface PlayerService {
    Player save(Player player);

    Player getById(Long id);

    List<Player> getAll();

    void delete(Long id);
}
