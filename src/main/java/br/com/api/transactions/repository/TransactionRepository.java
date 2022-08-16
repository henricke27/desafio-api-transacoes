package br.com.api.transactions.repository;

import br.com.api.transactions.domain.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class TransactionRepository implements AbstractRepositoryManager<Transaction> {

    private static List<Transaction> transactions = new ArrayList<>();
    @Override
    public void save(Transaction transaction) throws RuntimeException {
        transactions.add(transaction);
    }
    @Override
    public void deleteAll() throws RuntimeException{
        transactions.removeAll(getTransactions());
    }
    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
