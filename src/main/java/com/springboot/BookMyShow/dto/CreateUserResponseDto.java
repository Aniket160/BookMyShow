
package com.springboot.BookMyShow.dto;

import com.springboot.BookMyShow.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponseDto {
    private User user;
}
