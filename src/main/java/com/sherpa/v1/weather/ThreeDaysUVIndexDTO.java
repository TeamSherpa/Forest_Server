package com.sherpa.v1.weather;

import com.google.gson.annotations.SerializedName;
import com.sherpa.weather.parse.UVIndex;
import lombok.Data;

@Data
public class ThreeDaysUVIndexDTO {
    @SerializedName("day00")
    private UVIndex today;
    @SerializedName("day01")
    private UVIndex tomorrow;
    @SerializedName("day02")
    private UVIndex dayAfterTomorrow;
}
