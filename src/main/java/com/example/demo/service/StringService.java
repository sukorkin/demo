package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Map;

public interface StringService {
    public User getUser();

    public String getSimpleString();

    public void fillModel (String name, Map<String, Object> model);

    public String getHelloString(String name);
}
