package com.javarush.tracker.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.tracker.model.command.TagCommand;
import com.javarush.tracker.service.TagService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "apiTagsServlet", value = "/api/tags")
public class TagApiServlet extends HttpServlet implements Servlet {

    private ObjectMapper objectMapper;
    private TagService tagService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        tagService = (TagService) servletContext.getAttribute("tagService");
        objectMapper = (ObjectMapper) servletContext.getAttribute("objectMapper");

        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        sendObjectAsJson(objectMapper, response, tagService.findAll());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        var tagCommand = getObjectFromBody(objectMapper, req, TagCommand.class);
        var tagDTO = tagService.save(tagCommand);

        sendObjectAsJson(objectMapper, resp, tagDTO);
    }

}