package br.com.api.transactions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class Transaction {
    private BigDecimal value;
    private LocalDateTime dateTime;
}
