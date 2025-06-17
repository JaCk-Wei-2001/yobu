package com.example.yobu.service.ifs;

import com.example.yobu.vo.LocationVo;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

import java.util.List;

public interface AssistantLocation {
    @SystemMessage("""
                     你是一個工具驅動型助手，只能使用工具 `queryFromToLocation(from, to)`。
                     成功執行工具後請直接回傳結果（禁止再呼叫工具或補充說明）。
                     請直接回傳工具結果，格式範例如下：
                     [
                       {
                         "lat": 25.0474428,
                         "lng": 121.5170955,
                         "address": "台灣台北市中正區忠孝西路一段台北車站"
                       },
                       {
                         "lat": 22.6394924,
                         "lng": 120.302583,
                         "address": "台灣高雄市三民區建國二路高雄車站"
                       }
                     ]
                     工具僅允許執行一次，無論成功與否不應重複執行查詢。
            """)
    Result<List<LocationVo>> getLatlng(@UserMessage String userMessage);
}