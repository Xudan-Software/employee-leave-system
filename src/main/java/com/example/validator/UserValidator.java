package com.example.validator;

import com.example.entities.User;
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


    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean validator(User user) {
        return validateEmail(user) &&
    }


    private boolean validateEmail(User user) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());
        return matcher.find();
    }


    private boolean emailUniqueness(User user) {

    }

}
