package ru.javamentor.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("It's my second Spring MVC application");
        messages.add("now it's working with Hibernate");
        messages.add("version 0.1 by aug'23 ");
        model.addAttribute("messages", messages);
        return "index";
    }

}