package com.task.football.manager.service;

public interface TransferService {
    void sellPlayer(Long teamId, Long playerId);

    double getFullTransferSum(Long playerId);
}
