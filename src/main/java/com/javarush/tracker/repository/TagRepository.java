package com.javarush.tracker.repository;

import com.javarush.tracker.model.dto.PageDTO;
import com.javarush.tracker.model.entity.Tag;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class TagRepository implements Repository<Tag, Long> {

    @Override
    public Optional<Tag> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Tag> findAll(Session session) {
        return session.createQuery("from Tag", Tag.class).list();
    }

    @Override
    public PageDTO<Tag> findAll(int page, int size) {
        return null;
    }

    @Override
    public void save(Tag tag, Session session) {
        session.persist(tag);
    }

    @Override
    public void delete(Tag tag) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Tag update(Tag tag) {
        return null;
    }
}
