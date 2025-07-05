package com.example.yobu.controller;

import com.example.yobu.service.ifs.UserService;
<<<<<<< HEAD
import com.example.yobu.vo.*;
=======
import com.example.yobu.vo.BasicRes;
import com.example.yobu.vo.RegisterReq;
>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
@RequestMapping(value = "user")
=======
@RequestMapping(value = "user/")
>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44
@CrossOrigin
@RestController
public class UserServiceController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "register")
<<<<<<< HEAD
    public BasicRes register(@Valid @RequestBody RegisterReq req) {
        return userService.register(req);
    }

    @PostMapping(value = "login")
    public LoginRes login(@Valid @RequestBody LoginReq req) {
        return userService.login(req);
    }
=======
    public BasicRes register(@Valid @RequestBody RegisterReq req){
        return userService.register(req);
    }

>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44
}
