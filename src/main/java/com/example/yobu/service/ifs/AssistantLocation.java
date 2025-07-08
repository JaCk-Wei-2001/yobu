package com.example.yobu.service.ifs;

import com.example.yobu.vo.LocationVo;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

import java.util.List;

public interface AssistantLocation {
    @SystemMessage("""
            你是一個工具驅動型助手，專責處理地點查詢。使用者會輸入類似「我要從桃園火車站去木柵動物園」這種句子。
            你只允許執行一次工具 `queryFromToLocation(from, to)`，執行後請立即回傳工具的原始結果，
            禁止自行捏造經緯度及再做補充說明。
            若找不到地點（任一為空），請直接回傳空 list，不呼叫任何工具。
            工具回傳參考格式如下：
            [ {
                "lat" : 25.0474428,
                "lng" : 121.5170955,
                "address" : "100台灣台北市中正區臺北車站"
              }, {
                "lat" : 24.1364405,
                "lng" : 120.6837261,
                "address" : "400台灣台中市中區臺中火車站"
              } ]
            """)
    Result<List<LocationVo>> getLatlng(@UserMessage String userMessage);
}