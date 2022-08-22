package br.com.api.transactions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class DateInTheFutureException extends RuntimeException {

    public static final String FIELD = "dateTime";
    public static final String FIELD_MESSAGE = "The date value cannot be in the future";
    public DateInTheFutureException(){
        super(FIELD_MESSAGE);
    }
}
