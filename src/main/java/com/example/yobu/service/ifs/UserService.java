package com.example.yobu.service.ifs;

import com.example.yobu.entity.User;
import com.example.yobu.vo.*;

import com.example.yobu.vo.BasicRes;
import com.example.yobu.vo.RegisterReq;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    public BasicRes register(RegisterReq req);

    public LoginRes login(LoginReq req);

    public UserDetails loadUserByUsername(String email);
}
