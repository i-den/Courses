package com.example.demo.service;

import com.example.demo.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto user);

    UserDto getUser(String email);

    UserDto getUserByUserId(String id);

    UserDto updateUser(String userId, UserDto userDto);

    void deleteUser(String userId);

    List<UserDto> getUsers(int page, int limit);
}
