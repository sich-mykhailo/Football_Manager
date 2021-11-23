package com.task.football.manager.service.mapper;

import com.task.football.manager.dto.request.FootballTeamRequestDto;
import com.task.football.manager.dto.response.FootballTeamResponseDto;
import com.task.football.manager.model.FootballTeam;
import com.task.football.manager.model.Player;
import com.task.football.manager.service.FootballTeamService;
import com.task.football.manager.service.PlayerService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class FootballTeamDtoMapper implements
        RequestDtoMapper<FootballTeamRequestDto, FootballTeam>,
        ResponseDtoMapper<FootballTeamResponseDto, FootballTeam> {
    private final PlayerService playerService;
    private final FootballTeamService footballTeamService;

    public FootballTeamDtoMapper(PlayerService playerService,
                                 FootballTeamService footballTeamService) {
        this.playerService = playerService;
        this.footballTeamService = footballTeamService;
    }

    @Override
    public FootballTeam mapToModel(FootballTeamRequestDto dto) {
        FootballTeam footballTeam = new FootballTeam();
        footballTeam.setCommission(dto.getCommission());
        footballTeam.setBalance(dto.getBalance());
        footballTeam.setCity(dto.getCity());
        footballTeam.setCountry(dto.getCountry());
        footballTeam.setName(dto.getName());
        return footballTeam;
    }

    @Override
    public FootballTeamResponseDto mapToDto(FootballTeam footballTeam) {
        FootballTeamResponseDto responseDto = new FootballTeamResponseDto();
        responseDto.setId(footballTeam.getId());
        responseDto.setCommission(footballTeam.getCommission());
        responseDto.setBalance(footballTeam.getBalance());
        responseDto.setCity(footballTeam.getCity());
        responseDto.setName(footballTeam.getName());
        responseDto.setCountry(footballTeam.getCountry());
        responseDto.setPlayers(footballTeam.getPlayers().stream()
                .map(Player::getFirstName)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
