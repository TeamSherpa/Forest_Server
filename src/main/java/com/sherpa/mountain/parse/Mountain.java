package com.sherpa.mountain.parse;

import com.sherpa.v1.mountain.MountainDTO;
import lombok.Data;

@Data
public class Mountain {
    private String mntiadd;
    private String mntiadmin;
    private String mntiadminnum;
    private String mntidetails;
    private String mntihigh;
    private String mntilistno;
    private String mntiname;
    private String mntisname;
    private String mntisummary;
    private String mntitop;

    public MountainDTO toMountainDTO() {
        if (mntihigh.equals(" ")) {
            mntihigh = "0";
        }
        return new MountainDTO(mntilistno, mntiname, Integer.parseInt(mntihigh), mntiadd, mntiadmin, mntidetails, mntisummary, null, 1);
    }
}