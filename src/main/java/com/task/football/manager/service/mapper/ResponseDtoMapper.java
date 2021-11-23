package com.task.football.manager.service.mapper;

public interface ResponseDtoMapper<R, M> {
    R mapToDto(M t);
}
