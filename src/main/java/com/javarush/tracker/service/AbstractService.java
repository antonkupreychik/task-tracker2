package com.javarush.tracker.service;

import com.javarush.tracker.mapper.Mapper;
import com.javarush.tracker.model.command.Command;
import com.javarush.tracker.model.dto.DTO;
import com.javarush.tracker.model.dto.PageDTO;
import com.javarush.tracker.model.entity.Entity;
import com.javarush.tracker.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractService<E extends Entity, C extends Command, D extends DTO> {

    private final Mapper<E, D, C> mapper;
    private final Repository repository;
    private final SessionFactory sessionFactory;

    AbstractService(Mapper<E, D, C> mapper, Repository repository, SessionFactory sessionFactory) {
        this.mapper = mapper;
        this.repository = repository;
        this.sessionFactory = sessionFactory;
    }

    public D save(C c) {
        try (Session session = sessionFactory.openSession()) {
            var entity = mapper.mapToEntity(c);
            repository.save(entity, session);
            return mapper.mapToDTO(entity);
        } catch (Exception e) {
            return null;
        }
    }

    public PageDTO<D> findAll(int page, int size) {
        var result = repository.findAll(page, size);
        return null;
    }
}