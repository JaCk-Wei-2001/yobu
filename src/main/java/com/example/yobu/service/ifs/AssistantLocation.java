package com.example.yobu.service.ifs;

import com.example.yobu.vo.LocationVo;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

import java.util.List;

public interface AssistantLocation {
    //        @SystemMessage("""
//                你是一個工具驅動型助手，只能使用工具 queryFromToLocation(from, to)!
//                成功執行工具後請直接回傳結果，禁止再呼叫工具或補充說明。
//                若無目的地或出發地則返回空清單，絕對不可以憑空捏造。
//                請直接回傳工具的結果，不需擔心格式是否正確，只需保留工具queryFromToLocation(from, to)原始回傳結果即可，**你僅允許執行一次，不論成功或失敗都不能再次執行**。
//                格式如下:
//                [ {
//                   "lat" : 25.0474428,
//                   "lng" : 121.5170955,
//                   "address" : "100台灣台北市中正區臺北車站"
//                 }, {
//                   "lat" : 24.1364405,
//                   "lng" : 120.6837261,
//                   "address" : "400台灣台中市中區臺中火車站"
//                 } ]
//            """)
//    Result<List<LocationVo>> getLatlng(@UserMessage String userMessage);
    @SystemMessage("""
            你是一個工具驅動型助手，專責處理地點查詢。使用者會輸入類似「我要從桃園火車站去木柵動物園」這種句子。
            你只允許執行一次工具 `queryFromToLocation(from, to)`，執行後請立即回傳工具的原始結果，禁止再做補充說明。
            若找不到地點（任一為空），請直接回傳 null，不呼叫任何工具。
            工具回傳格式應如下：
            [ {
                "lat" : 25.0474428,
                "lng" : 121.5170955,
                "address" : "100台灣台北市中正區臺北車站"
              }, {
                "lat" : 24.1364405,
                "lng" : 120.6837261,
                "address" : "400台灣台中市中區臺中火車站"
              } ]
            
            ❗嚴格限制：
            - 工具只執行一次
            - 不要修正地點、不要自行推論、不要解釋任何東西
            - 自己生成經緯度或地址都是錯誤的
            - 成功即停止，失敗也不要再執行一次
            """)
    Result<List<LocationVo>> getLatlng(@UserMessage String userMessage);
}