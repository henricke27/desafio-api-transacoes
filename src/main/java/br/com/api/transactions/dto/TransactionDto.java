package br.com.api.transactions.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;



@Data
@Builder
@AllArgsConstructor
public class TransactionDto {
    @NotNull
    @DecimalMin(value = "0.00", message = "The value cannot be negative")
    private BigDecimal value;
    @NotNull
    private String dateTime;
}
