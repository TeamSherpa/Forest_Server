package com.sherpa.v1.weather;

import lombok.Data;

@Data
public class YesterdayWeatherDTO {
    private String alertYn;
    private String stormYn;
    private String skyCode;
    private String tempMax;
    private String tempMin;
    private String rain;
    private String snow;

    public YesterdayWeatherDTO(String alertYn, String stormYn, String skyCode, String tempMax, String tempMin, String rain, String snow) {
        this.alertYn = alertYn;
        this.stormYn = stormYn;
        this.skyCode = skyCode;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.rain = rain;
        this.snow = snow;
    }
}
