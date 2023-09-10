package com.vivek.book.store.service;

import com.vivek.book.store.dto.UserDto;
import com.vivek.book.store.entity.User;

import java.util.List;

public interface MyUserService {
    User saveUser(UserDto userDto);
    User getUserById(Long userId);
    List<User> getUsers();

    User updateUser(UserDto userDto,Long userId);

    void deleteUser(UserDto userDto);
}
