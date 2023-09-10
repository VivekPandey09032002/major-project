package com.vivek.book.store.controller;

import com.vivek.book.store.dto.UserDto;
import com.vivek.book.store.entity.User;
import com.vivek.book.store.service.MyUserDetailService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/user")
@Controller
@RequiredArgsConstructor
public class UserController {


    private final ModelMapper mapper;

    private final MyUserDetailService userDetailService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String userLogin() {
        return "user-login";
    }

    @GetMapping("/logout")
    public String userLogout() {
        return "home";
    }

    @GetMapping("/register")
    public String userRegister(@ModelAttribute("userDto") UserDto userDto) {
        return "user-register";
    }

    @PostMapping("/register")
    public String saveUser(UserDto userdto) {
        userdto.setPassword(passwordEncoder.encode(userdto.getPassword()));
        userDetailService.saveUser(userdto);
        return "home";
    }

}
