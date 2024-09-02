package com.javarush.tracker.service;

import com.javarush.tracker.mapper.Mapper;
import com.javarush.tracker.model.command.TaskCommand;
import com.javarush.tracker.model.dto.TaskDto;
import com.javarush.tracker.model.entity.Task;
import com.javarush.tracker.repository.Repository;
import org.hibernate.SessionFactory;

public class TaskService extends AbstractService<Task, TaskCommand, TaskDto> {

    public TaskService(Mapper<Task, TaskDto, TaskCommand> mapper,
                       Repository repository,
                       SessionFactory sessionFactory) {
        super(mapper, repository, sessionFactory);
    }

}
