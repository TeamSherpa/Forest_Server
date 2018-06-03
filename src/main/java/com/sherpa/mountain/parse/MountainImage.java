package com.sherpa.mountain.parse;

import com.sherpa.v1.mountain.MountainImageDTO;
import lombok.Data;

@Data
public class MountainImage {
    private String code;
    private String imgfilename;
    private String imgname;
    private int imgno;

    public MountainImageDTO toMountainImageDTO() {
        return new MountainImageDTO(code, imgfilename);
    }
}
