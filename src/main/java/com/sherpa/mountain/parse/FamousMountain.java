package com.sherpa.mountain.parse;

import com.sherpa.v1.mountain.FamousMountainDTO;
import lombok.Data;

@Data
public class FamousMountain {
    String mntncd;
    String mntnm;

    public FamousMountainDTO toFamousMountainDTO() {
        return new FamousMountainDTO(mntncd, mntnm);
    }
}
