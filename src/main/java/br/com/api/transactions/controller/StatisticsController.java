package br.com.api.transactions.controller;

import br.com.api.transactions.domain.Statistics;
import br.com.api.transactions.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping(path = "statistics")
    public ResponseEntity<Statistics> calculateStatistics(){
        return new ResponseEntity<Statistics>(statisticsService.calculateStatistics(), HttpStatus.OK);
    }
}
