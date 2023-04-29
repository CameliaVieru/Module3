package com.example.temacurs16;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.*;

@RestController
public class SpringController {
    private static final Map<String, User> userRegistered = new HashMap<>();
    private static final Map<String, User> loggedUser = new HashMap<>();

    @PostMapping("/register")
    public UserWithoutPassword handleRegister(@Valid @RequestBody User user) {
        if(userRegistered.containsKey(user.getEmail())){
            throw new ValidationException("Email already exists!");
        } else {
            userRegistered.put(user.getEmail(), user);
        }
        UserWithoutPassword userWithoutPassword = new UserWithoutPassword();
        userWithoutPassword.setFirstName(user.getFirstName());
        userWithoutPassword.setLastName(user.getLastName());
        userWithoutPassword.setEmail(user.getEmail());
        return userWithoutPassword;
    }

    @PostMapping("/login")
    public ResponseEntity<UserWithoutPassword> handleLogin(@RequestBody UserLogin userLogin) {
        if(!userRegistered.containsKey(userLogin.getEmail())){
            throw new ValidationException("This user does not exists.");
        } else if(!userRegistered.get(userLogin.getEmail()).getPassword().equals(userLogin.getPassword())){
            throw new ValidationException("Wrong Password");
        }
        UserWithoutPassword userWithoutPassword = new UserWithoutPassword();
        userWithoutPassword.setFirstName(userRegistered.get(userLogin.getEmail()).getFirstName());
        userWithoutPassword.setLastName(userRegistered.get(userLogin.getEmail()).getLastName());
        userWithoutPassword.setEmail(userLogin.getEmail());
        if(loggedUser.containsKey(userLogin.getEmail())){
            return new ResponseEntity<>(userWithoutPassword,HttpStatus.ACCEPTED);
        }
        loggedUser.put(userLogin.getEmail(), userRegistered.get(userLogin.getEmail()));
        return new ResponseEntity<>(userWithoutPassword,HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public Map<String, String> handleValidationEx(ValidationException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Validation exception: ", ex.getMessage());
        return errors;
    }

}
