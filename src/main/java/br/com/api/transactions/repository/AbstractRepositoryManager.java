package br.com.api.transactions.repository;

import java.util.List;

public interface AbstractRepositoryManager<T> {
    void save(T object);
    void deleteAll();
    List<T> findAll();
}
