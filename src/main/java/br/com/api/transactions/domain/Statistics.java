package br.com.api.transactions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {

    private long count = 0L;
    private double average = 0.00;
    private double sum = 0.00;
    private double max = 0.00;
    private double min = 0.00;
}
