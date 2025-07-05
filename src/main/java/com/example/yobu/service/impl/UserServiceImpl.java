package com.example.yobu.service.impl;

import com.example.yobu.constants.ResMessage;
import com.example.yobu.dao.UserDao;
<<<<<<< HEAD
import com.example.yobu.entity.User;
import com.example.yobu.service.ifs.UserService;
import com.example.yobu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
=======
import com.example.yobu.service.ifs.UserService;
import com.example.yobu.vo.BasicRes;
import com.example.yobu.vo.RegisterReq;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
<<<<<<< HEAD
public class UserServiceImpl implements UserService, UserDetailsService {
=======
public class UserServiceImpl implements UserService {
>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44

    @Autowired
    private UserDao userDao;

<<<<<<< HEAD
    // 註冊
=======
>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicRes register(RegisterReq req) {
        // 判斷是否註冊過
<<<<<<< HEAD
        if (userDao.getUserByEmail(req.getEmail()) != null) {
=======
        if (userDao.getQuizByEmail(req.getEmail()) != null) {
>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44
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
<<<<<<< HEAD

    // 登入
    @Transactional(rollbackFor = Exception.class)
    @Override
    public LoginRes login(LoginReq req) {
        // 判斷是否有帳號
        String email = req.getEmail();
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            return new LoginRes(ResMessage.EMAIL_NOT_FOUND.getCode(), //
                    ResMessage.EMAIL_NOT_FOUND.getMessage());
        }
        // 帳密是否匹配
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean passwordIsMatch = encoder.matches(req.getPassword(), user.getPassword());
        if (!passwordIsMatch) {
            return new LoginRes(ResMessage.PASSWORD_DO_NOT_MATCH.getCode(), //
                    ResMessage.PASSWORD_DO_NOT_MATCH.getMessage());
        }
        return new LoginRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage(), //
                "token");
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("USER") // 可根據需要改為 user.getRole()
                .build();
    }
=======
>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44
}
