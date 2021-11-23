package com.task.football.manager.config;

import com.task.football.manager.model.FootballTeam;
import com.task.football.manager.model.Player;
import com.task.football.manager.service.FootballTeamService;
import com.task.football.manager.service.PlayerService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final FootballTeamService footballTeamService;
    private final PlayerService playerService;

    public DataInitializer(FootballTeamService footballTeamService, PlayerService playerService) {
        this.footballTeamService = footballTeamService;
        this.playerService = playerService;
    }

    @PostConstruct
    public void inject() {
        FootballTeam firstFootballTeam = new FootballTeam();
        firstFootballTeam.setName("dinamo");
        firstFootballTeam.setCountry("UA");
        firstFootballTeam.setCity("Kyiv");
        firstFootballTeam.setBalance(100000);
        firstFootballTeam.setCommission(0.02);
        List<Player> players = new ArrayList<>();
        firstFootballTeam.setPlayers(players);
        footballTeamService.save(firstFootballTeam);

        FootballTeam secondFootballTeam = new FootballTeam();
        secondFootballTeam.setName("Team");
        secondFootballTeam.setCountry("UA");
        secondFootballTeam.setCity("Lviv");
        secondFootballTeam.setBalance(100000);
        secondFootballTeam.setCommission(0.1);
        List<Player> secondTeamPlayers = new ArrayList<>();
        secondFootballTeam.setPlayers(secondTeamPlayers);
        footballTeamService.save(secondFootballTeam);

        Player misha = new Player();
        misha.setFirstName("Misha");
        misha.setLastName("Sich");
        misha.setAge(28);
        misha.setCareerStartTime(LocalDate.of(2020, 2, 18));
        misha.setFootballTeam(firstFootballTeam);
        playerService.save(misha);
        players.add(misha);

        Player ivan = new Player();
        ivan.setFirstName("Ivan");
        ivan.setLastName("Ivanov");
        ivan.setAge(19);
        ivan.setCareerStartTime(LocalDate.of(2021, 3, 15));
        ivan.setFootballTeam(firstFootballTeam);
        playerService.save(ivan);
        players.add(ivan);
    }
}
