package br.com.api.transactions.util;

import br.com.api.transactions.domain.Transaction;
import br.com.api.transactions.dto.TransactionDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionUtil {

    public static final String STRiNG_DATE_TIME = LocalDateTime.now().toString();
    public static final BigDecimal VALUE = new BigDecimal("123.00");
    public static Transaction createTransaction(){
        return Transaction.builder()
                .value(VALUE)
                .dateTime(LocalDateTime.now())
                .build();
    }

    public static TransactionDto createTransactionDto(){
        return TransactionDto.builder()
                .value(VALUE)
                .dateTime(STRiNG_DATE_TIME)
                .build();
    }
}
