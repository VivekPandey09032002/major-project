package com.vivek.book.store.controller;

import com.vivek.book.store.dto.UserDto;
import com.vivek.book.store.service.MyUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
@Controller
@RequiredArgsConstructor
public class UserController {

    private final MyUserDetailService userDetailService;



    @GetMapping("/login")
    public String userLogin(Model model, @RequestParam(required = false) String error,@RequestParam(required = false) String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "user-login";
    }


    @GetMapping("/register")
    public String userRegister(@ModelAttribute("userDto") UserDto userDto) {
        return "user-register";
    }

    @PostMapping("/register")
    public String saveUser(UserDto userdto) {
        userDetailService.saveUser(userdto);
        return "home";
    }

}
