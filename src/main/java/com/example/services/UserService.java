package com.example.services;

import com.example.dto.UserDTO;
import com.example.entities.User;
import com.example.mapper.UserMapper;

public class UserService {

    /* steps for creating a user
    1. map the all variables in the userDTO to user object,
       except manager
    2. check the validation of credentials
    3. find the manager by id and set manager of the user object
    4. save user into database and repository
    *
    * */
    public User createUser(UserDTO userDTO){
        User user = UserMapper.createUser(userDTO);

        //if user role is reportee, set up the manager of this user
    }

}
