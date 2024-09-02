package com.javarush.tracker.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.tracker.mapper.TagMapper;
import com.javarush.tracker.mapper.TaskMapper;
import com.javarush.tracker.provider.SessionProvider;
import com.javarush.tracker.provider.TaskTrackerSessionProvider;
import com.javarush.tracker.repository.TagRepository;
import com.javarush.tracker.repository.TaskRepository;
import com.javarush.tracker.service.TagService;
import com.javarush.tracker.service.TaskService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.hibernate.SessionFactory;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        //utils
        ObjectMapper objectMapper = new ObjectMapper();

        //hibernate
        SessionProvider sessionProvider = new TaskTrackerSessionProvider();
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();

        //tags
        TagRepository tagRepository = new TagRepository();
        TagMapper tagMapper = TagMapper.INSTANSE;
        TagService tagService = new TagService(sessionFactory, tagMapper, tagRepository);

        //tasks
        TaskRepository taskRepository = new TaskRepository();
        TaskMapper taskMapper = TaskMapper.INSTANSE;
        TaskService taskService = new TaskService(taskMapper, taskRepository, sessionFactory);

        ctx.setAttribute("tagService", tagService);
        ctx.setAttribute("taskService", taskService);
        ctx.setAttribute("objectMapper", objectMapper);


        ServletContextListener.super.contextInitialized(sce);
    }
}