package com.javarush.tracker.model.command;

import com.javarush.tracker.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TaskCommand implements Command {
    private String title;
    private String description;
    private Status status;
}
