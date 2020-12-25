package com.mapper;

import com.dto.TodoDto;
import com.model.TodoItem;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {

        @Named("toTodo")
        TodoItem toToDo(TodoDto toDoDto);

        @Named("toTodoDto")
        TodoDto toToDoDto(TodoItem toDo);

        @IterableMapping(qualifiedByName = "toTodoList")
        List<TodoItem> toToDoList(List<TodoDto> toDoDtoList);

        @IterableMapping(qualifiedByName = "toTodoDtoList")
        List<TodoDto> toToDoDtoList(List<TodoItem> toDos);


}