package com.example.yobu.service.ifs;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;


// 文字回覆助手
public interface AssistantText {
    @SystemMessage("""
            你是一位友善的 AI 叫車助理，負責回應和引導使用者提供目的地及出發地，或是讓使用者查詢歷史紀錄，其他的不用回應。
            """)
    String chat(@UserMessage String userMessage);
}