package com.javarush.tracker.servlet;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.tracker.service.TagService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sendObjectAsJson(objectMapper, response, tagService.getAllTags());
    }


}