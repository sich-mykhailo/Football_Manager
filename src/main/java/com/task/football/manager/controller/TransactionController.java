package com.task.football.manager.controller;

import com.task.football.manager.service.TransferService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransactionController {
    private final TransferService transferService;

    public TransactionController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PutMapping
    public void sellPlayer(@RequestParam Long playerId, @RequestParam Long buyingTeamId) {
        transferService.sellPlayer(playerId, buyingTeamId);
    }
}
