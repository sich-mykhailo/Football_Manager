package com.task.football.manager.service;

import com.task.football.manager.model.FootballTeam;
import com.task.football.manager.repository.FootballTeamRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FootballTeamServiceImpl implements FootballTeamService {
    private final FootballTeamRepository footballTeamRepository;

    public FootballTeamServiceImpl(FootballTeamRepository footballTeamRepository) {
        this.footballTeamRepository = footballTeamRepository;
    }

    @Override
    public FootballTeam save(FootballTeam footballTeam) {
        return footballTeamRepository.save(footballTeam);
    }

    @Override
    public FootballTeam getById(Long id) {
        return footballTeamRepository.getById(id);
    }

    @Override
    public List<FootballTeam> getAll() {
        return footballTeamRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        footballTeamRepository.delete(footballTeamRepository.getById(id));
    }
}
