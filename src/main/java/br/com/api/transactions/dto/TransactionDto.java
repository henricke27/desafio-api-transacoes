package br.com.api.transactions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;



@Data
@Builder
@AllArgsConstructor
public class TransactionDto {
    @NotNull(message = "The value cannot be null")
    private BigDecimal value;
    @NotNull(message = "The value cannot be null")
    private String dateTime;
}
