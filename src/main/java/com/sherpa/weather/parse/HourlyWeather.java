package com.sherpa.weather.parse;

import com.sherpa.v1.weather.HourlyWeatherDTO;
import lombok.Data;

import java.util.Map;
@Data
public class HourlyWeather {
    Map<String, String> common;
    Map<String, String> grid;
    Map<String, String> wind;
    Map<String, String> precipitation;
    Map<String, String> sky;
    Map<String, String> temperature;
    String humidity;
    String lightning;
    String sunRiseTime;
    String sunSetTime;

    public HourlyWeatherDTO toHourlyWeatherDTO(){
        return new HourlyWeatherDTO(wind.get("wspd"), precipitation.get("sinceOntime"), getFallenType(precipitation.get("type")),
                sky.get("name"), temperature.get("tc"), temperature.get("tmax"), temperature.get("tmin"),
                humidity, lightning, sunRiseTime, sunSetTime, common.get("alertYn"), common.get("stormYn"),
                grid.get("latitude"), grid.get("longitude"));
    }

    public String getFallenType(String type){
        String fallenType = null;
        switch (precipitation.get("type")) {
            case "0":
                fallenType = "현상없음";
                break;
            case "1":
                fallenType = "비";
                break;
            case "2":
                fallenType = "비/눈";
                break;
            case "3":
                fallenType = "눈";
                break;
        }
        return fallenType;
    }
}
