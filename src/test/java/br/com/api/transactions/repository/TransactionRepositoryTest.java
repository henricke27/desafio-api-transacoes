package br.com.api.transactions.repository;

import br.com.api.transactions.domain.Transaction;
import br.com.api.transactions.util.TransactionUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void save_persistATransactionInMemory_whenSuccessful(){
        Transaction transaction = TransactionUtil.createTransaction();

        transactionRepository.save(transaction);

        Assertions.assertThat(transactionRepository.getTransactions())
                .isNotNull()
                .isNotEmpty()
                .contains(transaction);
        Assertions.assertThat(transactionRepository.getTransactions().size())
                .isEqualTo(1);
    }

    @Test
    void deleteAll_deleteAllTransactionsInMemory_whenSuccessul(){
        transactionRepository.save(TransactionUtil.createTransaction());
        transactionRepository.deleteAll();

        Assertions.assertThat(transactionRepository.getTransactions())
                .isNotNull()
                .isEmpty();

    }
}