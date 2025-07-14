package com.example.yobu.service.ifs;

import com.example.yobu.vo.LocationVo;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

import java.util.List;

public interface AssistantLocation {
    @SystemMessage("""
            你是一個工具驅動型助手，分析使用者的目的地和出發地後，
            你只允許使用工具 `queryFromToLocation(from, to)`查詢經緯度，
            執行後請立即回傳工具的原始結果，禁止自行捏造經緯度及再做補充說明。
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
              ，若使用者未提供目的地或出發地任意一項，請回傳空陣列。
            """)
    Result<List<LocationVo>> getLatlng(@UserMessage String userMessage);
}