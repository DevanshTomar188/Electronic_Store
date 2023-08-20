package com.project.electronic.store.services.impl;

import com.project.electronic.store.dtos.UserDto;
import com.project.electronic.store.entities.User;
import com.project.electronic.store.repositories.UserRepository;
import com.project.electronic.store.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
   @Autowired
    private UserRepository userRepository;
   @Autowired
   private ModelMapper mapper;
    @Override
    public UserDto createUser(UserDto userDto)
    {
        String userid= UUID.randomUUID().toString();
        userDto.setUserid((userid));
        User user =dtotoentity((userDto));//dto->entity
        User saveduser=userRepository.save(user);
        UserDto newDto=entitytodto(saveduser);//entity->dto
        return newDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userid) {

        User user= userRepository.findById(userid).orElseThrow(()->new RuntimeException("User not found exception"));
        user.setName((userDto.getName()));
        user.setAbout(userDto.getAbout());
        userDto.setGender(userDto.getGender());
        userDto.setPassword((userDto.getPassword()));
        user.setImagename(userDto.getImagename());
        User updateduser=userRepository.save(user);
        UserDto updatedDto=entitytodto((updateduser));

        return updatedDto;
    }
    @Override
    public void deleteUser(String userid)
    {
        User user=userRepository.findById(userid).orElseThrow(()->new RuntimeException("User not found"));
        userRepository.delete(user);
    }
    @Override
    public List<UserDto> getalluser() {
        List<User> users=userRepository.findAll();
        List<UserDto> dtolist=users.stream().map(user -> entitytodto(user)).collect(Collectors.toList());

        return dtolist;
    }

    @Override
    public UserDto getUserById(String userid) {
        User user=userRepository.findById(userid).orElseThrow(()-> new RuntimeException("user not found"));
        return entitytodto(user);

    }

    @Override
    public UserDto getUserByEmail(String email)
    {
        User user=userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("user not found"));
        return entitytodto(user);

    }

    @Override
    public List<UserDto> searchuser(String keyword) {
        List<User> users=userRepository.findByNameContaining(keyword);
        List<UserDto> dtolist=users.stream().map(user -> entitytodto(user)).collect(Collectors.toList());

        return dtolist;
    }
    private UserDto entitytodto(User savedUser)
    {
        return mapper.map(savedUser, UserDto.class);
    }
    private User dtotoentity(UserDto userDto)
    {
        return mapper.map(userDto, User.class);

    }
}
