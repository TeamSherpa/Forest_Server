package com.sherpa.weather.parse;

import lombok.Data;

@Data
public class DailyWeather {
    String skyName;
    String tempMax;
    String tempMin;
    String rain;
    String snow;

    public DailyWeather(String skyName, String tempMax, String tempMin) {
        this.skyName = skyName;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
    }

    public DailyWeather(String skyName, String tempMax, String tempMin, String rain, String snow) {
        this.skyName = skyName;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.rain = rain;
        this.snow = snow;
    }
}
