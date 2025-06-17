package com.example.yobu.service.impl;

import com.example.yobu.service.ifs.Assistant;
import dev.langchain4j.model.chat.ChatLanguageModel;
import com.example.yobu.service.ifs.LlmService;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.stereotype.Service;


@Service
public class LlmServiceImpl implements LlmService {

    private final Assistant assistant;

    public LlmServiceImpl() {
        ChatLanguageModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .modelName("gemini-1.5-flash")
                .build();

        this.assistant = AiServices.create(Assistant.class, model);
    }

    @Override
    public String chat(String userMessage) {
        return assistant.chat(userMessage);
    }

}