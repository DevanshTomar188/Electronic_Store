package com.project.electronic.store.services;

import com.project.electronic.store.dtos.UserDto;

import java.util.List;

public interface UserService

{
    UserDto createUser(UserDto userDto);


    UserDto updateUser(UserDto userDto,String userid);
    void deleteUser(String userid);

    List<UserDto> getalluser();

    UserDto getUserById(String userid);
    UserDto getUserByEmail(String email);

    List<UserDto> searchuser(String keyword);



}

