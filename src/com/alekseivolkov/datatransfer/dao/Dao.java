package com.alekseivolkov.datatransfer.dao;

import java.util.List;
import java.util.Optional;

public interface Dao <K, T> {

    List<T> findAll();

    Optional<T> findByAll(K id);

    boolean delete(K id);

    void update(T entity);

    T save(T entity);
}
