package com.sda.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface DAO<T, E extends Serializable> {

    List<T> findAll();

    String delete(T object);

    void insert(T object);

    void update(T object);

    Optional<T> findById(long id);


}
