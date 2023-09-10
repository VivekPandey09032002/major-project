package com.vivek.book.store.service;

import com.vivek.book.store.dto.UserDto;
import com.vivek.book.store.entity.User;
import com.vivek.book.store.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService , MyUserService {

    private final UserRepository userRepository;


    private final ModelMapper mapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow( () -> new UsernameNotFoundException("no user found with username " + username));
    }


    @Override
    public User saveUser(UserDto userDto) {
        return userRepository.save(mapper.map(userDto,User.class));
    }

    @Override
    public User getUserById(Long userId) {
        // TODO find user by id
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(UserDto userDto,Long userId) {
        // TODO update user
        return null;
    }

    @Override
    public void deleteUser(UserDto userDto) {
        userRepository.delete(mapper.map(userDto,User.class));
    }
}
