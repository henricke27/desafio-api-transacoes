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
    void save_PersistATransactionInMemory_whenSuccessful(){
        Transaction transaction = TransactionUtil.createTransaction();

        transactionRepository.save(transaction);

        Assertions.assertThat(transactionRepository.getTransactions())
                .isNotNull()
                .isNotEmpty()
                .contains(transaction);
        Assertions.assertThat(transactionRepository.getTransactions().size())
                .isEqualTo(1);
    }
}