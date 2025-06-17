package com.example.yobu.controller;

import com.example.yobu.service.ifs.UserService;
import com.example.yobu.vo.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "user")
@CrossOrigin
@RestController
public class UserServiceController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "register")
    public BasicRes register(@Valid @RequestBody RegisterReq req) {
        return userService.register(req);
    }

    @PostMapping(value = "login")
    public LoginRes login(@Valid @RequestBody LoginReq req) {
        return userService.login(req);
    }
}
