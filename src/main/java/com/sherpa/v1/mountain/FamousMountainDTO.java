package com.sherpa.v1.mountain;

import lombok.Data;

// true = 0, false = 1
@Data
public class FamousMountainDTO {
    private String code;
    private String name;

    public FamousMountainDTO(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
