package com.example.yobu.controller;

<<<<<<< HEAD
import com.example.yobu.service.ifs.LlmService;
import com.example.yobu.vo.ChatRes;
=======
import com.example.yobu.service.ifs.Assistant;
import com.example.yobu.service.ifs.LlmService;
import com.example.yobu.vo.ChatReq;
import jakarta.validation.Valid;
>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "ai/")
@CrossOrigin
@RestController
public class LlmServiceController {

    @Autowired
    private LlmService llmService;

    @PostMapping(value = "chat")
<<<<<<< HEAD
    public ChatRes chat(@RequestParam("userMessage") String userMessage){
=======
    public String chat(@RequestParam("userMessage") String userMessage){
>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44
    return llmService.chat(userMessage);
    }
}
