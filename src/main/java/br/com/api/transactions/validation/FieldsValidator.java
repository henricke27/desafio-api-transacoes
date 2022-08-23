package br.com.api.transactions.validation;

import br.com.api.transactions.dto.TransactionDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FieldsValidator {

    public static boolean isFuture(LocalDateTime dateTimeToBeValidated){
        int i = dateTimeToBeValidated.compareTo(LocalDateTime.now());
        if(i < 1){
            return false;
        }
        return true;
    }

    public static boolean isNegative(BigDecimal value) {
        int i = value.compareTo(new BigDecimal("0.00"));
        if(i >= 0){
            return false;
        }
        return true;
    }
}
