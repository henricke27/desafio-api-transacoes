package br.com.api.transactions.service;

import br.com.api.transactions.domain.Transaction;
import br.com.api.transactions.dto.TransactionDto;
import br.com.api.transactions.exception.DateInTheFutureException;
import br.com.api.transactions.repository.TransactionRepository;
import br.com.api.transactions.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Log4j2
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public void save(TransactionDto transactionDto){
        LocalDateTime currentDateTime = DateUtil
                .convertStringOffSetDateTimeToLocalDateTime(transactionDto.getDateTime());

        if(DateUtil.isFuture(currentDateTime)){
            throw new DateInTheFutureException();
        }

        log.info(currentDateTime);

        Transaction transaction = Transaction.builder()
                .dateTime(currentDateTime)
                .value(transactionDto.getValue())
                .build();

        try{
            transactionRepository.save(transaction);
        }catch (RuntimeException ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }

        log.info(transactionRepository.getTransactions());
    }

    public void deleteAll() {
        try{
            transactionRepository.deleteAll();
        }catch(RuntimeException ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
