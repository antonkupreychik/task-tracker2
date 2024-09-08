package com.javarush.tracker.mapper;

import com.javarush.tracker.model.command.TagCommand;
import com.javarush.tracker.model.dto.TagDto;
import com.javarush.tracker.model.entity.Tag;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper extends Mapper<Tag, TagDto, TagCommand> {

    TagMapper INSTANSE = Mappers.getMapper(TagMapper.class);

    @Override
    Tag mapToEntity(TagCommand entity);

    @Override
    TagDto mapToDTO(Tag entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tag partialUpdate(TagDto tagDto, @MappingTarget Tag tag);
}