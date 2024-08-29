package com.javarush.tracker.service;

import com.javarush.tracker.mapper.TagMapper;
import com.javarush.tracker.model.dto.TagDto;
import com.javarush.tracker.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@RequiredArgsConstructor
public class TagService {

    private final SessionFactory sessionFactory;
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;


    public List<TagDto> getAllTags() {
        try (Session session = sessionFactory.openSession()) {
            return tagRepository.findAll(session)
                    .stream()
                    .map(tagMapper::toDto)
                    .toList();
        }
    }
}
