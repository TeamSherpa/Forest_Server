package com.sherpa.v1.mountain;

import lombok.Data;

@Data
public class MountainImageDTO {
    private String code;
    private String imageURL;

    public MountainImageDTO(String code, String imageURL) {
        this.code = code;
        this.imageURL = imageURL;
    }
}
