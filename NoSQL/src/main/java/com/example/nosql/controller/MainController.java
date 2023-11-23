package com.example.nosql.controller;

import com.example.nosql.document.UserDocument;
import com.example.nosql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserDocument>> findAllUser() {
        List<UserDocument> users = userService.findAllUser();

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(users);
    }

    @GetMapping("/user/{uid}")
    public void findUser(@PathVariable("uid") String uid) {

    }

    @PostMapping("/user")
    public ResponseEntity<UserDocument> insertUser(UserDocument user) {

        UserDocument resultUser = userService.insertUser(user);

        return ResponseEntity
                .ok()
                .body(resultUser);
    }

    @PutMapping("/user")
    public void updateUser(UserDocument use) {

    }

    @DeleteMapping("/user/{uid}")
    public void deleteUser(@PathVariable("uid") String uid) {

    }
}
