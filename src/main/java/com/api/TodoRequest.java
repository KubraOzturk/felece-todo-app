package com.api;

import com.dto.TodoDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TodoRequest {
    @JsonProperty("TodoDto")
    TodoDto todoDto;
}
