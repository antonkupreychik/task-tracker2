package com.javarush.tracker.mapper;

import com.javarush.tracker.model.command.TaskCommand;
import com.javarush.tracker.model.dto.TaskDto;
import com.javarush.tracker.model.entity.Task;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper extends Mapper<Task, TaskDto, TaskCommand> {

    TaskMapper INSTANSE = Mappers.getMapper(TaskMapper.class);

    @Override
    Task mapToEntity(TaskCommand entity);

    @Override
    TaskDto mapToDTO(Task entity);
}
