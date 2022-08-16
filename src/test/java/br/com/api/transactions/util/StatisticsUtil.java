package br.com.api.transactions.util;

import br.com.api.transactions.domain.Statistics;

public class StatisticsUtil {
    public static Statistics buildStatisticsToTests(){
        return Statistics.builder()
                .count(10)
                .average(123.456)
                .sum(1234.56)
                .max(123.56)
                .min(12.34)
                .build();

    }
}
