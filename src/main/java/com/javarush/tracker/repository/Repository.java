package com.javarush.tracker.repository;

import com.javarush.tracker.model.dto.PageDTO;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public interface Repository<E, ID extends Serializable> {
    Optional<E> findById(ID id);

    List<E> findAll(Session session);

    PageDTO<E> findAll(int page, int size);

    void save(E e, Session session);

    void delete(E e);

    void deleteById(ID id);

    E update(E e);
}
