package com.sherpa.v1.weather;

import com.sherpa.weather.parse.DailyWeather;
import lombok.Data;

@Data
public class SummaryWeatherDTO {
    private String alertYn;
    private String stormYn;
    private DailyWeather yesterday;
    private DailyWeather today;
    private DailyWeather tomorrow;
    private DailyWeather dayAfterTomorrow;

    public SummaryWeatherDTO(String alertYn, String stormYn, DailyWeather yesterday, DailyWeather today, DailyWeather tomorrow, DailyWeather dayAfterTomorrow) {
        this.alertYn = alertYn;
        this.stormYn = stormYn;
        this.yesterday = yesterday;
        this.today = today;
        this.tomorrow = tomorrow;
        this.dayAfterTomorrow = dayAfterTomorrow;
    }
}
