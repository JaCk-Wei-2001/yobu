package com.example.yobu.controller;

import com.example.yobu.service.ifs.LlmService;
import com.example.yobu.vo.ChatRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "ai/")
@CrossOrigin
@RestController
public class LlmServiceController {

    @Autowired
    private LlmService llmService;

    @PostMapping(value = "chat")
    public ChatRes chat(@RequestParam("userMessage") String userMessage){
    return llmService.chat(userMessage);
    }
}
