package com.api;

import com.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserRequest {
    @JsonProperty("UserDto")
    UserDto userDto;
}
