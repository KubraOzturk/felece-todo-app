package com.service;

import com.dto.TodoDto;

import java.util.Date;
import java.util.List;

public interface TodoServiceIn {
    TodoDto addToDo(TodoDto toDoDto);
    void deleteToDo(long id);
    TodoDto updateToDo(TodoDto toDoDto);
    TodoDto getToDo(long id);
    List<TodoDto> getList();
    List<TodoDto> getListByUserId(long userId);
    List<TodoDto> getListByDate(Long id, Date startDate, Date endDate);
    List<TodoDto> getListByContainingTitle(String title);

}
