package com.secure.notesApplication.utils;

import com.secure.notesApplication.models.User;
import com.secure.notesApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {

    @Autowired
    UserRepository userRepository;

    public Long loggedInUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserName(authentication.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getUserId();
    }

    public User loggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserName(authentication.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user;
    }
}
