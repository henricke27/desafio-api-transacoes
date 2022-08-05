package br.com.api.transactions.service;

import br.com.api.transactions.domain.Transaction;
import br.com.api.transactions.repository.TransactionRepository;
import br.com.api.transactions.util.TransactionUtil;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;
    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setup(){
        BDDMockito.doNothing().when(transactionRepository).save(ArgumentMatchers.any(Transaction.class));
        BDDMockito.doNothing().when(transactionRepository).deleteAll();
    }

    @Test
    void save_persistATransactionInMemoryAndExceptionIsNotThrows_whenSuccessful(){
        Transaction transaction = TransactionUtil.createTransaction();

        Assertions.assertThatCode(() -> transactionRepository.save(transaction))
                .doesNotThrowAnyException();
    }

    @Test
    void deleteAll_deleteAllTransactionsInMemory_whenSuccessul(){
        Assertions.assertThatCode(() -> transactionService.deleteAll())
                .doesNotThrowAnyException();
    }
}