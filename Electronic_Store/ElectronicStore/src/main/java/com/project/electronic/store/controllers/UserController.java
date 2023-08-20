package com.project.electronic.store.controllers;

import com.project.electronic.store.dtos.ApiresponseMessage;
import com.project.electronic.store.dtos.UserDto;
import com.project.electronic.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController
{
    @Autowired(required = true)
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
        UserDto userDto1 = userService.createUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }
    @PutMapping("/{userid")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userid") String userid,
                                              @RequestBody UserDto userDto) {
        UserDto UpdateduserDto = userService.updateUser(userDto, userid);
        return new ResponseEntity<>(UpdateduserDto, HttpStatus.OK);

    }

    @DeleteMapping
    public  ResponseEntity<ApiresponseMessage> deleteuser(@PathVariable String userid)
    {
        userService.deleteUser(userid);
        ApiresponseMessage message= ApiresponseMessage.builder().message("user deleted").success(true).status(HttpStatus.OK).build();

        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getallusers()
    {
        return new ResponseEntity<>(userService.getalluser(),HttpStatus.OK);
    }
    @GetMapping("/{userid}")
    public ResponseEntity<UserDto> getuser(@PathVariable String userid)
    {
        return new ResponseEntity<>(userService.getUserById(userid),HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getuserbyenail(@PathVariable String email)
    {
        return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
    }









}
