package com.example.yobu.service.impl;

import com.example.yobu.constants.ResMessage;
import com.example.yobu.service.ifs.AssistantLocation;
import com.example.yobu.service.ifs.AssistantText;
import com.example.yobu.tool.LocationTool;
import com.example.yobu.vo.ChatRes;
import com.example.yobu.vo.LocationVo;
import dev.langchain4j.model.chat.ChatLanguageModel;
import com.example.yobu.service.ifs.LlmService;
import dev.langchain4j.model.chat.request.ResponseFormat;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.Result;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.langchain4j.model.chat.request.ResponseFormatType.JSON;

@Service
public class LlmServiceImpl implements LlmService {

    private final AssistantLocation assistantLocation;
    private final AssistantText assistantText;

    public LlmServiceImpl(LocationTool locationTool) {

        ChatLanguageModel modelLocation = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .modelName("gemini-1.5-flash")
                .responseFormat(ResponseFormat.builder().type(JSON).build())
                .build();


        this.assistantLocation = AiServices.builder(AssistantLocation.class)
                .chatLanguageModel(modelLocation)
                .tools(locationTool)
                .build();

        ChatLanguageModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .modelName("gemini-1.5-flash")
                .build();

        this.assistantText = AiServices.create(AssistantText.class, model);
    }

    @Override
    public ChatRes chat(String userMessage) {

        String aiResponse = assistantText.chat(userMessage);
        System.out.println("AI Response: " + aiResponse);
        Result<List<LocationVo>> result = assistantLocation.getLatlng(userMessage);
        List<LocationVo> locations = result.content();

        System.out.println("==============");
        System.out.println("aiResponse" + aiResponse);
        System.out.println("==============");
        System.out.println("result: " + result);
        System.out.println("==============");
        System.out.println("locations: " + locations);

        return new ChatRes(
                ResMessage.SUCCESS.getCode(),
                ResMessage.SUCCESS.getMessage(),
                aiResponse,
                locations
        );
    }
}
