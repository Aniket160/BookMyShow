package com.springboot.BookMyShow.service;

import com.springboot.BookMyShow.model.User;
import com.springboot.BookMyShow.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
   private UserRepository userRepository;


    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
