package com.sherpa.weather.parse;

import lombok.Data;

@Data
public class UVIndex {
    String index;
    String comment;

    public UVIndex(String index, String comment) {
        this.index = index;
        this.comment = comment;
    }
}
