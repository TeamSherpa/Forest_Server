package com.sherpa.mountain.parse;

import com.sherpa.v1.mountain.MountainDTO;
import lombok.Data;

@Data
public class Mountain {
    String mntiadd;
    String mntiadmin;
    String mntiadminnum;
    String mntidetails;
    String mntihigh;
    String mntilistno;
    String mntiname;
    String mntisname;
    String mntisummary;
    String mntitop;

    public MountainDTO toMountainDTO() {
        return new MountainDTO(mntilistno, mntiname, mntihigh, mntiadd, mntiadmin, mntidetails, mntisummary, null, 1);
    }
}