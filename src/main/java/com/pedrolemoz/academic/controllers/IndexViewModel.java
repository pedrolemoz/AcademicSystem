package com.pedrolemoz.academic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexViewModel {
    @GetMapping("/")
    public String index() {
        return "redirect:/courses/list_all_courses";
    }
}
