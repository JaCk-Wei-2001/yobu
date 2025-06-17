package com.example.yobu.service.ifs;

import com.example.yobu.vo.ChatRes;

public interface LlmService {

    ChatRes chat(String userMessage);
}

