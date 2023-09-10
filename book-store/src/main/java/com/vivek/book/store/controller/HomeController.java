package com.vivek.book.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping(path = {"/home","/"})
    public String homePage(){
        return "home";
    }
}
