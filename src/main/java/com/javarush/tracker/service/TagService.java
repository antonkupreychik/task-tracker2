package com.javarush.tracker.service;

import com.javarush.tracker.mapper.TagMapper;
import com.javarush.tracker.model.command.TagCommand;
import com.javarush.tracker.model.dto.TagDto;
import com.javarush.tracker.model.entity.Tag;
import com.javarush.tracker.repository.TagRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TagService extends AbstractService<Tag, TagCommand, TagDto> {
    private final SessionFactory sessionFactory;
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public TagService(SessionFactory sessionFactory,
                      TagMapper tagMapper,
                      TagRepository tagRepository) {
        super(tagMapper, tagRepository, sessionFactory);
        this.sessionFactory = sessionFactory;
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }


    public List<TagDto> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return tagRepository.findAll(session)
                    .stream()
                    .map(tagMapper::mapToDTO)
                    .toList();
        }
    }
}
