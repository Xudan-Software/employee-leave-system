package com.example.validator;

import com.example.entities.User;
import com.example.exceptions.InvalidEmailException;
import com.example.exceptions.InvalidPasswordException;
import com.example.exceptions.UserAlreadyRegisteredException;
import com.example.repository.UserRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This UserValidator class provides validation of user account information.
 * It verifies whether username is a valid email identifier and unique
 * It verifies password is valid and meet requirements
 */
public class UserValidator {
    private final UserRepository userRepository;
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_PASSWORD_REGEX =
        Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&-+=()]).{8,16}$",
            Pattern.CASE_INSENSITIVE);


    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void validator(User user) {
        validateEmail(user);
        validatePassword(user);
    }


    private void validateEmail(User user) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());
        if (!matcher.find()) {
            throw new InvalidEmailException();
        }
        if (userRepository.findByEmail(user.getEmail()).isEmpty()) {
            throw new UserAlreadyRegisteredException();
        }
    }


    private void validatePassword(User user) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher((user.getPassword()));
        if(!matcher.find()){
            throw new InvalidPasswordException();
        }
    }

}
