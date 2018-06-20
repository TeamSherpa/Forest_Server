package com.sherpa.weather.parse;

import com.sherpa.v1.weather.YesterdayWeatherDTO;
import com.sherpa.weather.parse.SpecialReport;

import java.util.Map;

public class YesterdayWeather {
    Map<String, String> common;
    Map<String, String> sky;
    Map<String, String> temperature;
    Map<String, String> precipitation;

    public YesterdayWeatherDTO toYesterdayWeatherDTO() {
        return new YesterdayWeatherDTO(common.get("alertYn"), common.get("stormYn"), sky.get("name"),
                Double.parseDouble(temperature.get("tmax")),
                Double.parseDouble(temperature.get("tmin")),
                Double.parseDouble(precipitation.get("rain")),
                Double.parseDouble(precipitation.get("snow")));
    }
}
