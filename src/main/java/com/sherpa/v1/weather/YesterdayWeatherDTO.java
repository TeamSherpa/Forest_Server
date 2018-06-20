package com.sherpa.v1.weather;

import com.sherpa.weather.parse.SpecialReport;
import lombok.Data;

import java.util.Map;
@Data
public class YesterdayWeatherDTO {
    private String alertYn;
    private String stormYn;
    private String skyName;
    private Double tempMax;
    private Double tempMin;
    private Double rain;
    private Double snow;
    private String uvIndex;
    private String uvComment;
    private String latitude;
    private String longitude;

    public YesterdayWeatherDTO(String alertYn, String stormYn, String skyName, Double tempMax, Double tempMin, Double rain, Double snow, String latitude, String longitude) {
        this.alertYn = alertYn;
        this.stormYn = stormYn;
        this.skyName = skyName;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.rain = rain;
        this.snow = snow;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
