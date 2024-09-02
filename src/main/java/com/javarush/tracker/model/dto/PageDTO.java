package com.javarush.tracker.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public final class PageDTO<T> {
    private List<T> content;
    private int totalPages;
    private long totalElements;
    private int size;
    private int number;

    public PageDTO(List<T> content, int number, int pageSize, int size) {
        this.content = content;
        if (pageSize != 0) {
            this.totalPages = size / pageSize;
        } else {
            this.totalPages = size;
        }
        this.totalElements = size;
        this.size = pageSize;
        this.number = number;
    }
}
