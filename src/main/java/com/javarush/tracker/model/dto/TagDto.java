package com.javarush.tracker.model.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.javarush.tracker.model.entity.Tag}
 */
@Value
public class TagDto implements Serializable {
    Long id;
    String name;
    String color;
}