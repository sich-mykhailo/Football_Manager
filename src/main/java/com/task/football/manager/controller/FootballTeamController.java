package com.task.football.manager.controller;

import com.task.football.manager.dto.request.FootballTeamRequestDto;
import com.task.football.manager.dto.response.FootballTeamResponseDto;
import com.task.football.manager.model.FootballTeam;
import com.task.football.manager.service.FootballTeamService;
import com.task.football.manager.service.mapper.FootballTeamDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/football-teams")
public class FootballTeamController {
    private final FootballTeamService teamService;
    private final FootballTeamDtoMapper teamMapper;

    public FootballTeamController(FootballTeamService teamService,
                                  FootballTeamDtoMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    @GetMapping("/{id}")
    public FootballTeamResponseDto get(@PathVariable Long id) {
        return teamMapper.mapToDto(teamService.getById(id));
    }

    @GetMapping
    public List<FootballTeamResponseDto> getAll() {
        return teamService.getAll().stream()
                .map(teamMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public FootballTeamResponseDto create(@RequestBody FootballTeamRequestDto requestDto) {
        return teamMapper.mapToDto(teamService
                .save(teamMapper.mapToModel(requestDto)));
    }

    @PutMapping("/{id}")
    public FootballTeamResponseDto update(
            @PathVariable Long id, @RequestBody FootballTeamRequestDto requestDto) {
        FootballTeam footballTeam = teamMapper.mapToModel(requestDto);
        footballTeam.setId(id);
        return teamMapper.mapToDto(teamService.save(footballTeam));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teamService.delete(id);
    }
}
