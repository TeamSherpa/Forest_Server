package com.sherpa.main;

import com.sherpa.mountain.parse.FamousMountain;
import com.sherpa.mountain.parse.Mountain;
import com.sherpa.mountain.parse.MountainImage;
import com.sherpa.mountain.parse.MountainInfomationParse;
import com.sherpa.network.CustomError;
import com.sherpa.network.ResponseUtil;
import com.sherpa.v1.mountain.MountainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MountainController {

    List<Mountain> mountains = MountainInfomationParse.shared.fetchMountainInfo();
    List<FamousMountain> famousMountains = MountainInfomationParse.shared.fetchFamousMountainInfo();

    @Autowired
    private MountainServiceImpl mountainServiceImpl;

    // 처음만 사용
    @RequestMapping("/insert/mountainInfo")
    public void insertMountainInfo() {
        for (Mountain mountain: mountains) {
            mountainServiceImpl.add(mountain.toMountainDTO());
            MountainImage mountainImage = MountainInfomationParse.shared.fetchMountainImage(mountain.getMntilistno());
            mountainServiceImpl.updateImage(mountainImage.toMountainImageDTO());
        }

        for (FamousMountain famousMountain: famousMountains) {
            mountainServiceImpl.updateFamous(famousMountain.toFamousMountainDTO());
        }
    }

    @RequestMapping(value = "/getTrailInfo", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getTrailInfo(@RequestParam("code") String code) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getTrailInfo(code));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.exceptionError(CustomError.NO_TRAILS.code, CustomError.NO_TRAILS.message);
        }
    }

    @RequestMapping("/getFamousMountains")
    public Map<String, Object> getFamousMountains() {
        try {
            return ResponseUtil.success(mountainServiceImpl.getFamousMountains());
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_TRAILS.code, CustomError.NO_TRAILS.message);
        }
    }

    @RequestMapping(value = "/getEducationProgram", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getEducationInfomation(@RequestParam("pageNo") int pageNo) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getEducationInfo(pageNo));
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.No_EDUCATION.code, CustomError.No_EDUCATION.message);
        }
    }

    @RequestMapping(value = "/getAroundMountain", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getAroundMountains(@RequestParam("city") String city) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getAroundMountains(city));
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_AROUND_MOUNTAINS.code, CustomError.NO_AROUND_MOUNTAINS.message);
        }
    }
}
