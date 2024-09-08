package com.javarush.tracker.mapper;

//E - Entity
//D - DTO
//C - Command
public interface Mapper<E, D, C> {
    E mapToEntity(C entity);

    D mapToDTO(E entity);
}
