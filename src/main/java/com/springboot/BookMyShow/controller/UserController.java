package com.springboot.BookMyShow.controller;

import com.springboot.BookMyShow.model.User;
import com.springboot.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user)
    {
          User newUser = userService.createUser(user);
         return "Hi "+user.getFirstName()+" Welcome to Book My Show";
    }
//    public CreateUserResponseDto createUser(CreateUserRequestDto request) {
//        User savedUser = userService.createUser(request.getEmail());
//        CreateUserResponseDto response = new CreateUserResponseDto();
//        response.setUser(savedUser);
//        return response;
//    }

}
