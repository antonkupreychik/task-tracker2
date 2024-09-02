package com.javarush.tracker.repository;

import com.javarush.tracker.model.dto.PageDTO;
import org.hibernate.Session;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Repository<T, ID extends Serializable> {
    Optional<T> findById(ID id);

    List<T> findAll();

    PageDTO<T> findAll(int page, int size);

    void save(T t, Session session);

    void delete(T t);

    void deleteById(ID id);

    T update(T t);
}
