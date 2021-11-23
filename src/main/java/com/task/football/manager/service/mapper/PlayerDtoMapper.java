package com.task.football.manager.service.mapper;

import com.task.football.manager.dto.request.PlayerRequestDto;
import com.task.football.manager.dto.response.PlayerResponseDto;
import com.task.football.manager.model.Player;
import com.task.football.manager.service.FootballTeamService;
import com.task.football.manager.service.PlayerService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class PlayerDtoMapper implements ResponseDtoMapper<PlayerResponseDto, Player>,
        RequestDtoMapper<PlayerRequestDto, Player> {
    private final PlayerService playerService;
    private final FootballTeamService footballTeamService;

    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public PlayerDtoMapper(PlayerService playerService, FootballTeamService footballTeamService) {
        this.playerService = playerService;
        this.footballTeamService = footballTeamService;
    }

    public Player mapToModel(PlayerRequestDto dto) {
        Player player = new Player();
        player.setAge(dto.getAge());
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player.setCareerStartTime(LocalDate.parse(dto.getCareerStartTime(), formatter));
        player.setFootballTeam(footballTeamService.getById(dto.getFootballTeamId()));
        return player;
    }

    @Override
    public PlayerResponseDto mapToDto(Player player) {
        PlayerResponseDto playerResponseDto = new PlayerResponseDto();
        playerResponseDto.setId(player.getId());
        playerResponseDto.setAge(player.getAge());
        playerResponseDto.setFirstName(player.getFirstName());
        playerResponseDto.setLastName(player.getLastName());
        playerResponseDto.setFootballTeamId(player.getFootballTeam().getId());
        playerResponseDto.setCareerStartTime(player.getCareerStartTime().format(formatter));
        return playerResponseDto;
    }
}
