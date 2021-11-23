package com.task.football.manager.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class FootballTeamResponseDto {
    private Long id;
    private String name;
    private String city;
    private String country;
    private double commission;
    private double balance;
    private List<String> players;
}
