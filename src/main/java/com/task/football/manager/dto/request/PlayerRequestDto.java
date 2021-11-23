package com.task.football.manager.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class PlayerRequestDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String careerStartTime;
    private Long footballTeamId;
    @Positive
    private int age;
}
