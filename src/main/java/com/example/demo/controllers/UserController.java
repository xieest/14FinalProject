package com.example.demo.controllers;

import com.example.demo.entities.CreateUserRequest;
import com.example.demo.entities.UpdateUserRequest;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "save new user to the database")
    @PostMapping(value = {"", "/create"}, consumes = {"application/json", "application/xml"})
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequest createUserRequest) {
        if(userService.createUser(createUserRequest)){
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "return a user given a username")
    @GetMapping("/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username){
       return userService.findUserByUsername(username)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "update the user")
    @PostMapping(value = {"/update"},consumes = {"application/json", "application/xml"})
    public ResponseEntity<Boolean> updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        if(userService.updateUser(updateUserRequest)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

}