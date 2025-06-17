package com.example.yobu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.langchain4j.model.output.structured.Description;

public class LocationVo {

    @JsonProperty("lat")
    @Description("緯度，例如：25.033967")
    private double lat;

    @JsonProperty("lng")
    @Description("經度，例如：120.96.515")
    private double lng;

    @JsonProperty("address")
    @Description("地點，例如：桃園火車站, 桃園市桃園區中正路1號")
    private String address;

    public LocationVo() {
        super();
    }

    public LocationVo(double lat, double lng, String address) {
        this.lat = lat;
        this.lng = lng;
        this.address = address;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getAddress() {
        return address;
    }
}
