package com.sherpa.v1.weather;

import lombok.Data;

@Data
public class DailyWeatherDTO {
    private String skyName;
    private String tempMax;
    private String tempMin;
    private String fallenForADay;
    private String fallenType;

    public DailyWeatherDTO(String skyName, String tempMax, String tempMin, String fallenForADay, String fallenType) {
        this.skyName = skyName;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.fallenForADay = fallenForADay;
        this.fallenType = fallenType;
    }

    public DailyWeatherDTO(String skyName, String tempMax, String tempMin) {
        this(skyName, tempMax, tempMin, null, null);
    }
}
