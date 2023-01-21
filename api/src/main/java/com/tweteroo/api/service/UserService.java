package com.tweteroo.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model._User;
import com.tweteroo.api.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public void signup(UserDTO dto){

       _User newUser = new _User(dto);

        userRepository.save(newUser);
        
    }

}
