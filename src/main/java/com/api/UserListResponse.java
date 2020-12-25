package com.api;

import com.dto.UserDto;
import lombok.Data;

import java.util.List;

@Data
public class UserListResponse {
    private List<UserDto> userDtoList;
}
