package com.sherpa.v1.mountain;

import lombok.Data;

@Data
public class MountainDTO {
    String code;
    String name;
    String height;
    String address;
    String management;
    String detail;
    String summary;
    String imageURL;
    int isFamous;

    public MountainDTO(String code, String name, String height, String address, String management, String detail, String summary, String imageURL, int isFamous) {
        this.code = code;
        this.name = name;
        this.height = height;
        this.address = address;
        this.management = management;
        this.detail = detail;
        this.summary = summary;
        this.imageURL = imageURL;
        this.isFamous = isFamous;
    }
}
