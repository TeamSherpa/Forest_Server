package com.sherpa.v1.weather;

import lombok.Data;

@Data
public class HourlyWeatherDTO {
    private String windSpeed;
    private String fallenForAnHour;
    private String fallenType;
    private String skyName;
    private String tempNow;
    private String tempMax;
    private String tempMin;
    private String humidity;
    private String lightningYn;
    private String sunRiseTime;
    private String sunSetTime;
    private String uvIndex;
    private String uvComment;
    private String alertYn;
    private String stormYn;
    private String alertSummary;
    private String alertMessage;
    private String latitude;
    private String longitude;


    public HourlyWeatherDTO(String windSpeed, String fallenForAnHour, String fallenType, String skyName, String tempNow, String tempMax, String tempMin, String humidity, String lightningYn, String sunRiseTime, String sunSetTime, String alertYn, String stormYn, String latitude, String longitude) {
        this.windSpeed = windSpeed;
        this.fallenForAnHour = fallenForAnHour;
        this.fallenType = fallenType;
        this.skyName = skyName;
        this.tempNow = tempNow;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.humidity = humidity;
        this.lightningYn = lightningYn;
        this.sunRiseTime = sunRiseTime;
        this.sunSetTime = sunSetTime;
        this.alertYn = alertYn;
        this.stormYn = stormYn;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
