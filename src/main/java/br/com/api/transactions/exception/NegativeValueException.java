package br.com.api.transactions.exception;

public class NegativeValueException extends RuntimeException {
    public static final String MESSAGE = "The value cannot be negative";
    public NegativeValueException(){
        super(MESSAGE);
    }
}
