package com.example.yobu.service.impl;

import com.example.yobu.constants.ResMessage;
import com.example.yobu.dao.UserDao;
import com.example.yobu.service.ifs.UserService;
import com.example.yobu.vo.BasicRes;
import com.example.yobu.vo.RegisterReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicRes register(RegisterReq req) {
        // 判斷是否註冊過
        if (userDao.getQuizByEmail(req.getEmail()) != null) {
            return new BasicRes(ResMessage.EMAIL_ALREADY_REGISTERED.getCode(), //
                    ResMessage.EMAIL_ALREADY_REGISTERED.getMessage());
        }

        // 加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(req.getPassword());

        // 註冊帳號 email、password、name
        userDao.insert(req.getEmail(), encodePassword, req.getName());

        return new BasicRes(ResMessage.SUCCESS.getCode(), //
                ResMessage.SUCCESS.getMessage());
    }
}
