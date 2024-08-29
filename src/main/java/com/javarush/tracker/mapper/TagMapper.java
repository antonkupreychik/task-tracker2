package com.javarush.tracker.mapper;

import com.javarush.tracker.model.dto.TagDto;
import com.javarush.tracker.model.entity.Tag;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {

    TagMapper INSTANSE = Mappers.getMapper(TagMapper.class);


    Tag toEntity(TagDto tagDto);

    TagDto toDto(Tag tag);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tag partialUpdate(TagDto tagDto, @MappingTarget Tag tag);
}