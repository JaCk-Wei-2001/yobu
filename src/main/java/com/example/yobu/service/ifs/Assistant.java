package com.example.yobu.service.ifs;

import dev.langchain4j.service.UserMessage;

public interface Assistant {

    String chat(String userMessage);
}
