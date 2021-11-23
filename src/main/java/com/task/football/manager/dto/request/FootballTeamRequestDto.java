package com.task.football.manager.dto.request;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class FootballTeamRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String city;
    @NotNull
    private String country;
    private double commission;
    private double balance;
}
