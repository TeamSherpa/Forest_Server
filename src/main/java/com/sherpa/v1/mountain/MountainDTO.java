package com.sherpa.v1.mountain;

import lombok.Data;

@Data
public class MountainDTO {
    private String code;
    private String name;
    private String height;
    private String address;
    private String management;
    private String detail;
    private String summary;
    private String imageURL;
    private int isFamous;

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
