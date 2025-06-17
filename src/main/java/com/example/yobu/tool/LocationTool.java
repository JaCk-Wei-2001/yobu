package com.example.yobu.tool;

import com.example.yobu.vo.LocationVo;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocationTool {

    @Tool(name = "getLatLng", value = "從 Google Maps API 獲取地址的經緯度")
    public LocationVo getLatLngFromMap(String address) {
        try {
            String url = UriComponentsBuilder
                    .fromHttpUrl("https://maps.googleapis.com/maps/api/geocode/json")
                    .queryParam("address", address)
                    .queryParam("language", "zh-TW")
                    .queryParam("key", System.getenv("GOOGLE_API_KEY"))
                    .build()
                    .toUriString();

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "Mozilla/5.0 (compatible; YobuBot/1.0)");
            headers.set("Accept-Language", "zh-TW");

            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            String json = response.getBody();
            if (json == null || json.isEmpty()) return null;

            JSONObject obj = new JSONObject(json);
            JSONArray results = obj.getJSONArray("results");
            if (results.isEmpty()) return null;

            JSONObject firstResult = results.getJSONObject(0);
            JSONObject location = firstResult
                    .getJSONObject("geometry")
                    .getJSONObject("location");

            double lat = location.getDouble("lat");
            double lng = location.getDouble("lng");
            String formattedAddress = firstResult.getString("formatted_address");
            LocationVo res = new LocationVo(lat, lng, formattedAddress);
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Tool(name = "queryFromToLocation", value = "判斷使否提供目的地及出發地，若有，則返回從出發地及目的地的經緯度及地址，若無目的地或出發地則返回空清單，不要憑空捏造")
    public List<LocationVo> queryFromToLocation(
            @P("出發地, 從") String from,
            @P("目的地, 往, 去") String to
    ) {
        System.out.println("有使用工具 queryFromToLocation");
        if (from == null || to == null || from.isBlank() || to.isBlank()) {
            return List.of(); // 立即返回空清單
        }
        List<LocationVo> results = new ArrayList<>();
        System.out.println("查詢出發地: " + from + ", 目的地: " + to);

        if (from != null && !from.isBlank()) {
            LocationVo fromLoc = getLatLngFromMap(from);
            if (fromLoc != null) {
                results.add(fromLoc);
            }
        }

        if (to != null && !to.isBlank()) {
            LocationVo toLoc = getLatLngFromMap(to);
            if (toLoc != null) {
                results.add(toLoc);
            }
        }
        return results;
    }
}