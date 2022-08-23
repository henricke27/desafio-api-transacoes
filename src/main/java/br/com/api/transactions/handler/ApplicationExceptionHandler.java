package br.com.api.transactions.handler;


import br.com.api.transactions.exception.DateInTheFutureException;
import br.com.api.transactions.exception.GlobalExceptionDescription;
import br.com.api.transactions.exception.NegativeValueException;
import br.com.api.transactions.exception.ValidationExceptionDescription;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream().map(f -> f.getField()).collect(Collectors.joining("; "));
        String fieldsMessage = fieldErrors.stream().map(f -> f.getDefaultMessage()).collect(Collectors.joining("; "));

        ValidationExceptionDescription validationExceptionDescription = ValidationExceptionDescription.builder()
                .title("Value validation")
                .description("Validation error for JSON field(s)")
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .timestamp(LocalDateTime.now())
                .field(fields)
                .fieldMessage(fieldsMessage)
                .build();

        return new ResponseEntity<>(validationExceptionDescription, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NegativeValueException.class)
    public ResponseEntity<Object> handleNegativeValueException(NegativeValueException ex) {

        ValidationExceptionDescription validationExceptionDescription = ValidationExceptionDescription.builder()
                .title("Value validation")
                .description("Validation error for JSON value field")
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .timestamp(LocalDateTime.now())
                .field("value")
                .fieldMessage(ex.getMessage())
                .build();

        return new ResponseEntity<>(validationExceptionDescription, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(DateInTheFutureException.class)
    public ResponseEntity<Object> handleDateInTheFutureException(DateInTheFutureException ex) {

        ValidationExceptionDescription validationExceptionDescription = ValidationExceptionDescription.builder()
                .title("Date validation")
                .description("Validation error for JSON dateTime field")
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .timestamp(LocalDateTime.now())
                .field("dateTime")
                .fieldMessage(ex.getMessage())
                .build();

        return new ResponseEntity<>(validationExceptionDescription, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Object> handleDateInTheFutureException(DateTimeParseException ex) {

        ValidationExceptionDescription validationExceptionDescription = ValidationExceptionDescription.builder()
                .title("Date validation")
                .description("Validation error parsing JSON dateTime field. " +
                        "The format must be: YYYY-mm-ddTHH:mm:ss.S±HH:mm (T is clock start).")
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .field("dateTime")
                .fieldMessage(ex.getMessage())
                .build();

        return new ResponseEntity<>(validationExceptionDescription, HttpStatus.BAD_REQUEST);
    }
}
