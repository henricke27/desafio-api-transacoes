package br.com.api.transactions.service;

import br.com.api.transactions.domain.Statistics;
import br.com.api.transactions.domain.Transaction;
import br.com.api.transactions.repository.TransactionRepository;
import br.com.api.transactions.util.TransactionUtil;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
class StatisticsServiceTest {
    @InjectMocks
    private StatisticsService statisticsService;
    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setup(){
        List<Transaction> transactions = List.of(TransactionUtil.createTransaction());

        BDDMockito.when(transactionRepository.getTransactions())
                .thenReturn(Collections.unmodifiableList(transactions));
    }

    @Test
    void calculateStatistics_calculeStatisticsOfTheLast60Seconds_whenSuccessful(){
        Statistics statistics = statisticsService.calculateStatistics();

        log.info(statistics);

        Assertions.assertThat(statistics.getCount())
                .isEqualTo(1);
        Assertions.assertThat(statistics.getAverage())
                .isEqualTo(123.00);
        Assertions.assertThat(statistics.getSum())
                .isEqualTo(123.00);
        Assertions.assertThat(statistics.getMax())
                .isEqualTo(123.00);
        Assertions.assertThat(statistics.getMin())
                .isEqualTo(123.00);
    }
}