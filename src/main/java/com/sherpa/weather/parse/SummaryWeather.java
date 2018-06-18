package com.sherpa.weather.parse;

import com.sherpa.v1.weather.SummaryWeatherDTO;
import lombok.Data;

import java.util.Map;

@Data
public class SummaryWeather {
    Map<String, String> common;
    Map<String, Map<String, String>> yesterday;
    Map<String, Map<String, String>> today;
    Map<String, Map<String, String>> tomorrow;
    Map<String, Map<String, String>> dayAfterTomorrow;

    public SummaryWeatherDTO toSummaryWeatherDTO(){
        return new SummaryWeatherDTO(common.get("alertYn"), common.get("stormYn"),
                new DailyWeather(yesterday.get("sky").get("name"), yesterday.get("temperature").get("tmax"), yesterday.get("temperature").get("tmin"), yesterday.get("precipitation").get("rain"), yesterday.get("precipitation").get("snow")),
                new DailyWeather(today.get("sky").get("name"), today.get("temperature").get("tmax"), today.get("temperature").get("tmin")),
                new DailyWeather(tomorrow.get("sky").get("name"), tomorrow.get("temperature").get("tmax"), tomorrow.get("temperature").get("tmin")),
                new DailyWeather(dayAfterTomorrow.get("sky").get("name"), dayAfterTomorrow.get("temperature").get("tmax"), dayAfterTomorrow.get("temperature").get("tmin")));
    }
}
