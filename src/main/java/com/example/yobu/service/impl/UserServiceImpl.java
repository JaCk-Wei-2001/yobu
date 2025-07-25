package com.example.yobu.service.impl;

import com.example.yobu.constants.ResMessage;
import com.example.yobu.dao.UserDao;
import com.example.yobu.security.JwtUtil;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.example.yobu.service.ifs.UserService;
import com.example.yobu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.yobu.vo.BasicRes;
import com.example.yobu.vo.RegisterReq;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtUtil jwtUtil;

    // 用 userName(email)找用戶資訊
    @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.yobu.entity.User user = userDao.getUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        // 這裡可以返回 UserDetails 物件
        return new User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }

    // 註冊
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicRes register(RegisterReq req) {
        // 判斷是否註冊過
        if (userDao.getUserByEmail(req.getEmail()) != null) {
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

    // 登入
    @Transactional(rollbackFor = Exception.class)
    @Override
    public LoginRes login(LoginReq req) {
        // 判斷是否有帳號
        String email = req.getEmail();
        com.example.yobu.entity.User user = userDao.getUserByEmail(email);
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
        String token = jwtUtil.generateTokenWithClaims(user.getEmail(), user.getId());

        return new LoginRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage(), //
                token);
    }
}
