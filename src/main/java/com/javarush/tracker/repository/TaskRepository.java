package com.javarush.tracker.repository;

import com.javarush.tracker.model.dto.PageDTO;
import com.javarush.tracker.model.entity.Task;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class TaskRepository implements Repository<Task, Long> {

    @Override
    public Optional<Task> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAll(Session session) {
        return session.createQuery("from Task").list();
    }

    @Override
    public PageDTO<Task> findAll(int page, int size) {
        return null;
    }

    @Override
    public void save(Task task, Session session) {
        session.persist(task);
    }

    @Override
    public void delete(Task task) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Task update(Task task) {
        return null;
    }
}
