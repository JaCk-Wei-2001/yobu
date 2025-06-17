package com.example.yobu.service.ifs;

import com.example.yobu.vo.BasicRes;
import com.example.yobu.vo.RegisterReq;

public interface UserService {

    public BasicRes register(RegisterReq req);
}
