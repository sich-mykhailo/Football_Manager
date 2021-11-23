package com.task.football.manager.service;

import com.task.football.manager.model.FootballTeam;
import com.task.football.manager.model.Player;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    private static final int COST_COEFFICIENT = 100000;
    private final PlayerService playerService;
    private final FootballTeamService footballTeamService;

    public TransferServiceImpl(PlayerService playerService,
                               FootballTeamService footballTeamService) {
        this.playerService = playerService;
        this.footballTeamService = footballTeamService;
    }

    public double getFullTransferSum(Long playerId) {
        Player player = playerService.getById(playerId);
        double experience = ChronoUnit.MONTHS.between(player.getCareerStartTime(),
                LocalDateTime.now());
        double transferPrice = (experience * COST_COEFFICIENT) / player.getAge();
        double teamCommission = transferPrice * player.getFootballTeam().getCommission();
        return transferPrice + teamCommission;
    }

    @Transactional
    public void sellPlayer(Long playerId, Long teamId) {
        Player player = playerService.getById(playerId);
        FootballTeam playersTeam = player.getFootballTeam();
        FootballTeam buyingTeam = footballTeamService.getById(teamId);
        double transferPrice = getFullTransferSum(playerId);
        buyingTeam.setBalance(buyingTeam.getBalance() - transferPrice);
        playersTeam.setBalance(playersTeam.getBalance() + transferPrice);
        player.setFootballTeam(buyingTeam);
        buyingTeam.getPlayers().add(player);
        playersTeam.getPlayers().remove(player);
    }
}

