package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto extends BaseDto{
    private String title;
    private String description;
    private Date date;
    private String status;
    private UserDto userDto;
}
