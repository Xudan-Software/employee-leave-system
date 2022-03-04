package com.example.mapper;

import com.example.dto.UserDTO;
import com.example.entities.User;

/***
 * This class provide static method to transform user object to userDTO object
 * or versus versa
 */
public class UserMapper {
    public static User createUser(UserDTO userDTO){
        //map variables from userDTO to user
        //todo: make a constructor that takes parameter of uto to user's
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAge(userDTO.getAge());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setAddress(userDTO.getAddress());
        user.setTag(userDTO.getTag());
        user.setPassword(userDTO.getPassword());

        return user;
    }
    //TODO:implement method of userDTO to user object
    public static UserDTO createUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        return userDTO;
    }
}
