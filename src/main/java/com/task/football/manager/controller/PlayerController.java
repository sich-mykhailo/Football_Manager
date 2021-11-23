package com.task.football.manager.controller;

import com.task.football.manager.dto.request.PlayerRequestDto;
import com.task.football.manager.dto.response.PlayerResponseDto;
import com.task.football.manager.model.Player;
import com.task.football.manager.service.FootballTeamService;
import com.task.football.manager.service.PlayerService;
import com.task.football.manager.service.mapper.PlayerDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
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
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;
    private final FootballTeamService teamService;
    private final PlayerDtoMapper playerMapper;

    public PlayerController(PlayerService playerService,
                            FootballTeamService teamService,
                            PlayerDtoMapper playerMapper) {
        this.playerService = playerService;
        this.teamService = teamService;
        this.playerMapper = playerMapper;
    }

    @GetMapping("/{id}")
    public PlayerResponseDto findById(@PathVariable Long id) {
        return playerMapper.mapToDto(playerService.getById(id));
    }

    @GetMapping
    public List<PlayerResponseDto> getAll() {
        return playerService.getAll().stream()
                .map(playerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public PlayerResponseDto create(@RequestBody @Valid PlayerRequestDto requestDto) {
        return playerMapper.mapToDto(playerService
                .save(playerMapper.mapToModel(requestDto)));
    }

    @PutMapping("/{id}")
    public PlayerResponseDto update(
            @PathVariable Long id, @RequestBody @Valid PlayerRequestDto requestDto) {
        Player player = playerMapper.mapToModel(requestDto);
        player.setId(id);
        return playerMapper.mapToDto(playerService.save(player));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }
}
