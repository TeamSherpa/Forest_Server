package com.sherpa.main;

import com.google.gson.JsonObject;
import com.sherpa.mountain.parse.FamousMountain;
import com.sherpa.mountain.parse.Mountain;
import com.sherpa.mountain.parse.MountainImage;
import com.sherpa.mountain.parse.MountainInfomationParse;
import com.sherpa.network.CustomError;
import com.sherpa.network.ResponseUtil;
import com.sherpa.v1.mountain.MountainDTO;
import com.sherpa.v1.mountain.MountainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MountainController {

    List<Mountain> mountains = MountainInfomationParse.shared.parse();
    List<FamousMountain> famousMountains = MountainInfomationParse.shared.famousParse();

    @Autowired
    private MountainServiceImpl mountainServiceImpl;

    @RequestMapping("/insert/mountainInfo")
    public void insertMountainInfo() {
        for (Mountain mountain: mountains) {
            mountainServiceImpl.add(mountain.toMountainDTO());
            MountainImage mountainImage = MountainInfomationParse.shared.parse(mountain.getMntilistno());
            mountainServiceImpl.updateImage(mountainImage.toMountainImageDTO());
        }

        for (FamousMountain famousMountain: famousMountains) {
            mountainServiceImpl.updateFamous(famousMountain.toFamousMountainDTO());
        }
    }

    @RequestMapping("/getTrailInfo/{code}")
    public Map<String, Object> getTrailInfo(@PathVariable("code") String code) {
        try {
            return mountainServiceImpl.getTrailInfo(code);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_TRAILS.code, CustomError.NO_TRAILS.message);
        }
    }

    @RequestMapping("/getFamousMountains")
    public List<MountainDTO> getFamousMountains() {
        return mountainServiceImpl.getFamousMountains();
    }
}
