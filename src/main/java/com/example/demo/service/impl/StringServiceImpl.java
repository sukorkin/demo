package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class StringServiceImpl implements StringService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public String getSimpleString () {
        System.out.println("Ok");
        return "Ok";
    }
    @Override
    public String getHelloString(String name) {
        String str = "Привет ";
        str = str +  name;
        System.out.println(str);
        return str;
    }
    @Override
    public User getUser() {
        List<User> users = (List<User>) userRepository.findAll();
        User user;
        if (users.isEmpty()) {
            user = new User();
            user.setAge(28);
            user.setName("Jon Smith");
            user.setEmail("test@test.com");
            userRepository.save(user);
        } else {
            user =  users.stream().findFirst().get();
        }
        System.out.println(user);
        return user;
    }

    @Override
    public void fillModel (String name, Map<String, Object> model) {
        model.put("name", name);
        System.out.println(model);
    }

}
