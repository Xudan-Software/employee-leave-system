package com.example.services;

import com.example.dto.UserDTO;
import com.example.entities.User;
import com.example.exceptions.NoManagerFoundById;
import com.example.mapper.UserMapper;
import com.example.repository.UserRepository;
import com.example.validator.UserValidator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class UserService {

    /* steps for creating a user
    1. map the all variables in the userDTO to user object,
       except manager
    2. check the validation of credentials
    3. find the manager by id and set manager of the user object
    4. save user into database and repository
    *
    * */
    UserValidator userValidator;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public User createUser(UserDTO userDTO){
        User user = UserMapper.createUser(userDTO);
        userValidator.validator(user);
        if(user.getRole() == User.RoleEnum.REPORTEE){
            User manager = userRepository.findById(userDTO.getManagerId()).orElseThrow(NoManagerFoundById::new);
            user.setManager(manager);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return user;
    }

}
