package kr.sungwoo.controller;

import kr.sungwoo.document.UserDocument;
import kr.sungwoo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserDocument>> findUser() {
        List<UserDocument> users = userService.findAllUser();

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(users);
    }

    @GetMapping("/user/{uid}")
    public void findUser(@PathVariable("uid") String uid) {

    }

    @PostMapping("/user/{uid}")
    public ResponseEntity<UserDocument> insertUser(UserDocument user) {
        UserDocument resultUser = userService.insertUser(user);

        return ResponseEntity.ok().body(resultUser);
    }


    @GetMapping("/user")
    public void updateUser() {

    }

    @GetMapping("/user")
    public void deleteUser() {

    }


}
