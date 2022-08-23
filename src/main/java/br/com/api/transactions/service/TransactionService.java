package br.com.api.transactions.service;

import br.com.api.transactions.domain.Transaction;
import br.com.api.transactions.dto.TransactionDto;
import br.com.api.transactions.exception.DateInTheFutureException;
import br.com.api.transactions.exception.NegativeValueException;
import br.com.api.transactions.repository.TransactionRepository;
import br.com.api.transactions.util.DateUtil;
import br.com.api.transactions.validation.FieldsValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public void save(TransactionDto transactionDto){
        LocalDateTime currentDateTime = DateUtil
                .convertStringOffSetDateTimeToLocalDateTime(transactionDto.getDateTime());

        if(FieldsValidator.isFuture(currentDateTime)){
            throw new DateInTheFutureException();
        }

        if(FieldsValidator.isNegative(transactionDto.getValue())){
            throw new NegativeValueException();
        }

        log.info(currentDateTime);

        Transaction transaction = Transaction.builder()
                .dateTime(currentDateTime)
                .value(transactionDto.getValue())
                .build();

        transactionRepository.save(transaction);

        log.info(transactionRepository.getTransactions());
    }

    public void deleteAll() {
        transactionRepository.deleteAll();
    }
}
