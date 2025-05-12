package com.example.nopaperbackend.rest_controllers;

import com.example.nopaperbackend.services.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RegisterApiController {
    @Autowired
    UserService userService;


    @PostMapping("/user/register")
    public ResponseEntity registerNewUser(@RequestParam("first_name")String first_name,
                                          @RequestParam("last_name")String last_name,
                                          @RequestParam("email")String email,
                                          @RequestParam("password")String password){

        if(first_name.isEmpty() || last_name.isEmpty() || email.isEmpty() || password.isEmpty()){
            return new ResponseEntity<>("Please Complete all Fields", HttpStatus.BAD_REQUEST);
        }

        // Encrypt / Hash Password:
        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());

        // Register New User:
        int result = userService.registerNewUserServiceMethod(first_name, last_name, email, hashed_password);

        if(result != 1){
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Success", HttpStatus.OK);

    }

}
