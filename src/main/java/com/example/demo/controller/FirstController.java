package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fistController/")
public class FirstController {
    @Autowired
    private StringService stringService;

    @GetMapping("getOk")
    public String getSimpleString () {
        return stringService.getSimpleString();
    }

    @GetMapping("getHello/{name}")
    public String getHelloString (@PathVariable String name) {
        return stringService.getHelloString(name);
    }

    @GetMapping("getUser")
    public User getUser () {
        return stringService.getUser();
    }
}
