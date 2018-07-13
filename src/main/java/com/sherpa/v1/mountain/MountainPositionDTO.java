package com.sherpa.v1.mountain;

import lombok.Data;

@Data
public class MountainPositionDTO {
    private String code;
    private String latitude;
    private String longitude;

    public MountainPositionDTO(String code, String latitude, String longitude) {
        this.code = code;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
