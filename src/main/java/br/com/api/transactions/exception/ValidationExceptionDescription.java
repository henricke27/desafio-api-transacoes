package br.com.api.transactions.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ValidationExceptionDescription extends GlobalExceptionDescription{
    private String field;
    private String fieldMessage;
}
