package com.service;

import com.dto.TodoDto;
import com.dto.UserDto;

import java.util.Date;
import java.util.List;

public interface UserServiceIn {
    UserDto addUser(UserDto userDto);
    void deleteUser(long id);
    UserDto updateUser(UserDto userDto);
    UserDto getUser(long userId);
    UserDto getByUserName(String username);
    List<UserDto> getUsers();
    List<TodoDto> getListByDateBetween(Date startDate, Date endDate);
}
