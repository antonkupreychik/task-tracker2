package com.javarush.tracker.model.dto;

import com.javarush.tracker.model.enums.Status;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.javarush.tracker.model.entity.Task}
 */
@Value
public class TaskDto implements Serializable, DTO {
    Long id;
    String title;
    String description;
    Status status;
}