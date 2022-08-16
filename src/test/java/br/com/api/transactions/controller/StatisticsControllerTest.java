package br.com.api.transactions.controller;

import br.com.api.transactions.domain.Statistics;
import br.com.api.transactions.service.StatisticsService;
import br.com.api.transactions.util.StatisticsUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class StatisticsControllerTest {

    @InjectMocks
    private StatisticsController statisticsController;

    @Mock
    private StatisticsService statisticsService;

    @BeforeEach
    void setup(){
        BDDMockito.when(statisticsService.calculateStatistics())
                .thenReturn(StatisticsUtil.buildStatisticsToTests());
    }

    @Test
    void calculateStatistics_calculeStatisticsOfTheLast60Seconds_whenSuccessful(){
        ResponseEntity<Statistics> statistics = statisticsController.calculateStatistics();

        Assertions.assertThat(statistics)
                .isNotNull();
        Assertions.assertThat(statistics.getBody())
                .isNotNull()
                .isEqualTo(StatisticsUtil.buildStatisticsToTests());
        Assertions.assertThat(statistics.getStatusCode())
                .isEqualTo(HttpStatus.OK);
    }
}