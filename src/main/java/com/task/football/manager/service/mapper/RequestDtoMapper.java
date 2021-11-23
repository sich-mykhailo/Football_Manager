package com.task.football.manager.service.mapper;

public interface RequestDtoMapper<R, M> {
    M mapToModel(R dto);
}
