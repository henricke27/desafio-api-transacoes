package br.com.api.transactions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Statistics {
    private long count;
    private double average;
    private double sum;
    private double max;
    private double min;
}
