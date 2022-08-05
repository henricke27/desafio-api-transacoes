package br.com.api.transactions.repository;

import java.util.List;

public interface AbstractRepositoryManager<T> {
    void save(T object) throws RuntimeException;
    void deleteAll() throws RuntimeException;
    List<T> findAll() throws RuntimeException;
}
