package br.com.api.transactions.controller;

import br.com.api.transactions.domain.Transaction;
import br.com.api.transactions.dto.TransactionDto;
import br.com.api.transactions.service.TransactionService;
import br.com.api.transactions.util.TransactionUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class TransactionControllerTest {

    @InjectMocks
    public TransactionController transactionController;
    @Mock
    public TransactionService transactionService;

    @BeforeEach
    void setup(){
        List<Transaction> transactions = List.of(TransactionUtil.createTransaction());

        BDDMockito.doNothing().when(transactionService).save(ArgumentMatchers.any(TransactionDto.class));
        BDDMockito.doNothing().when(transactionService).deleteAll();

    }

    @Test
    void save_persistATransactionInMemory_whenSuccessful(){
        TransactionDto transaction = TransactionUtil.createTransactionDto();

        ResponseEntity<Void> responseEntity = transactionController.save(transaction);

        Assertions.assertThat(responseEntity)
                .isNotNull();
        Assertions.assertThat(responseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void deleteAll_deleteAllTransactionsInMemory_whenSuccessul(){
        ResponseEntity<Void> entity = transactionController.deleteAll();

        Assertions.assertThat(entity)
                .isNotNull();
        Assertions.assertThat(entity.getStatusCode())
                .isEqualTo(HttpStatus.OK);
    }

}