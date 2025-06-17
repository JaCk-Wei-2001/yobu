package com.example.yobu.service.ifs;

import com.example.yobu.vo.*;

public interface UserService {

    public BasicRes register(RegisterReq req);

    public LoginRes login(LoginReq req);
}
