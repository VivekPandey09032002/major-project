package com.vivek.book.store.controller;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalController {


    @ExceptionHandler(UsernameNotFoundException.class)
    public String userNotFoundException(UsernameNotFoundException usernameNotFoundException, Model model){
        model.addAttribute("exceptionMessage",usernameNotFoundException.getMessage());
        return "error-page";
    }
}
