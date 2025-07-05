package com.example.yobu.service.impl;

<<<<<<< HEAD
import com.example.yobu.constants.ResMessage;
import com.example.yobu.service.ifs.AssistantLocation;
import com.example.yobu.service.ifs.AssistantText;
import com.example.yobu.tool.LocationTool;
import com.example.yobu.vo.ChatRes;
import com.example.yobu.vo.LocationVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.langchain4j.model.chat.ChatLanguageModel;
import com.example.yobu.service.ifs.LlmService;
import dev.langchain4j.model.chat.request.ResponseFormat;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.Result;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.langchain4j.model.chat.request.ResponseFormatType.JSON;

=======
import com.example.yobu.service.ifs.Assistant;
import dev.langchain4j.model.chat.ChatLanguageModel;
import com.example.yobu.service.ifs.LlmService;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.stereotype.Service;

>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44

@Service
public class LlmServiceImpl implements LlmService {

<<<<<<< HEAD
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

=======
    private final Assistant assistant;

    public LlmServiceImpl() {
>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44
        ChatLanguageModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .modelName("gemini-1.5-flash")
                .build();

<<<<<<< HEAD
        this.assistantText = AiServices.create(AssistantText.class, model);
    }

    @Override
    public ChatRes chat(String userMessage) {
        String aiResponse = assistantText.chat(userMessage);
        System.out.println("AI Response: " + aiResponse);
        Result<List<LocationVo>> result = assistantLocation.getLatlng(userMessage);
        List<LocationVo> locations = result.content();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(locations);
            System.out.println("🧾 JSON 輸出:\n" + json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ChatRes(
                ResMessage.SUCCESS.getCode(),
                ResMessage.SUCCESS.getMessage(),
                aiResponse,
                locations
        );
    }
=======
        this.assistant = AiServices.create(Assistant.class, model);
    }

    @Override
    public String chat(String userMessage) {
        return assistant.chat(userMessage);
    }

>>>>>>> d20e27d279a402c12c9d1f0c080dc925d6773d44
}