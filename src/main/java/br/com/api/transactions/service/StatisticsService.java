package br.com.api.transactions.service;

import br.com.api.transactions.domain.Statistics;
import br.com.api.transactions.repository.TransactionRepository;
import br.com.api.transactions.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class StatisticsService {

    private final TransactionRepository transactionRepository;
    private final static Long SECONDS = Long.valueOf("60");

    public Statistics calculateStatistics() {
        List<BigDecimal> transactionValues = transactionRepository.getTransactions().stream()
                .filter(t -> {
                    log.info(DateUtil.calculateSecondsDifference(t.getDateTime()));
                    return DateUtil.calculateSecondsDifference(t.getDateTime()) < SECONDS;
                })
                .map(t -> t.getValue())
                .collect(Collectors.toList());

        DoubleSummaryStatistics summary = transactionValues.stream()
                .collect(Collectors.summarizingDouble(BigDecimal::doubleValue));

        Statistics statistics;

        if(transactionValues.isEmpty()){
            statistics = new Statistics();
        }else{
            statistics = Statistics.builder()
                    .count(summary.getCount())
                    .average(summary.getAverage())
                    .max(summary.getMax())
                    .min(summary.getMin())
                    .sum(summary.getSum())
                    .build();
        }

        log.info(statistics);

        return statistics;
    }
}
