package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.repos.MessageRepository;
import com.example.demo.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping
public class MainController {
    @Autowired
    private StringService stringService;
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String home (Map<String, Object> model) {
        return "home";
    }
    @GetMapping("/getHtml")
    public String getHtml (@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        stringService.fillModel(name, model);
        return "test";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepository.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message();
        message.setText(text);
        message.setTag(tag);

        messageRepository.save(message);

        Iterable<Message> messages = messageRepository.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter.isBlank()) {
            messages = messageRepository.findAll();
        } else {
            messages = messageRepository.findByTag(filter);
        }

        model.put("messages", messages);

        return "main";
    }

}
