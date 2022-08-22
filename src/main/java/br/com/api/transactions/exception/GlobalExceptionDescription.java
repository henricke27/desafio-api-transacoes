package br.com.api.transactions.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class GlobalExceptionDescription {
    private String title;
    private String description;
    private Integer status;
    private LocalDateTime timestamp;
}
