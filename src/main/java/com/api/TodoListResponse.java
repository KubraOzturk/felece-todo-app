package com.api;

import com.dto.TodoDto;
import lombok.Data;

import java.util.List;

@Data
public class TodoListResponse {
    List<TodoDto> toDoList;
}
