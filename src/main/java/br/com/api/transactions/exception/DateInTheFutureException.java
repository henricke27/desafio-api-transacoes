package br.com.api.transactions.exception;

public class DateInTheFutureException extends RuntimeException {
    public static final String MESSAGE = "The date value cannot be in the future";
    public DateInTheFutureException(){
        super(MESSAGE);
    }
}
