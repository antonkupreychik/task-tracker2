package com.javarush.tracker.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.tracker.model.command.TaskCommand;
import com.javarush.tracker.service.TaskService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "apiTasksServlet", value = "/api/tasks")
public class TaskServlet extends HttpServlet implements Servlet {

    private TaskService taskService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        taskService = (TaskService) servletContext.getAttribute("taskService");
        objectMapper = (ObjectMapper) servletContext.getAttribute("objectMapper");

        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sendObjectAsJson(objectMapper, resp, taskService.findAll());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var taskCommand = getObjectFromBody(objectMapper, req, TaskCommand.class);
        var taskDTO = taskService.save(taskCommand);

        sendObjectAsJson(objectMapper, resp, taskDTO);
    }
}
