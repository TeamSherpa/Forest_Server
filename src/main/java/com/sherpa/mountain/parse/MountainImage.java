package com.sherpa.mountain.parse;

import com.sherpa.v1.mountain.MountainImageDTO;
import lombok.Data;

@Data
public class MountainImage {
    String code;
    String imgfilename;
    String imgname;
    int imgno;

    public MountainImageDTO toMountainImageDTO() {
        return new MountainImageDTO(code, imgfilename);
    }
}
