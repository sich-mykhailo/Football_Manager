package com.task.football.manager.dto.response;

import lombok.Data;

@Data
public class PlayerResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String careerStartTime;
    private Long footballTeamId;
    private int age;
}
