package br.com.api.transactions.util;

import br.com.api.transactions.domain.Transaction;
import br.com.api.transactions.dto.TransactionDto;

import java.math.BigDecimal;

public class TransactionUtil {

    public static final String STRiNG_DATE_TIME = "2020-08-07T12:34:56.789-03:00";
    public static final BigDecimal VALUE = new BigDecimal("123.00");
    public static Transaction createTransaction(){
        return Transaction.builder()
                .value(VALUE)
                .dateTime(DateUtil.convertStringOffSetDateTimeToLocalDateTime(STRiNG_DATE_TIME))
                .build();
    }

    public static TransactionDto createTransactionDto(){
        return TransactionDto.builder()
                .value(VALUE)
                .dateTime(STRiNG_DATE_TIME)
                .build();
    }
}
