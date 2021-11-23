package com.task.football.manager.service;

import com.task.football.manager.model.FootballTeam;
import java.util.List;

public interface FootballTeamService {
    FootballTeam save(FootballTeam footballTeam);

    FootballTeam getById(Long id);

    List<FootballTeam> getAll();

    void delete(Long id);
}
