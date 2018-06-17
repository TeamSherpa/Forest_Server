package com.sherpa.main;

import com.sherpa.exception.CustomError;
import com.sherpa.exception.PageException;
import com.sherpa.network.ResponseUtil;
import com.sherpa.v1.mountain.MountainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MountainController {

    /*
    List<Mountain> mountains = MountainInfomationParse.shared.fetchMountainInfo();
    List<FamousMountain> famousMountains = MountainInfomationParse.shared.fetchFamousMountainInfo();
    */
    @Autowired
    private MountainServiceImpl mountainServiceImpl;

    // 처음만 사용
    /*
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
    */

    @RequestMapping(value = "/getTrailInfo", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getTrailInfo(@RequestParam("code") String code) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getTrailInfo(code));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.exceptionError(CustomError.NO_TRAILS.code, CustomError.NO_TRAILS.message);
        }
    }

    @RequestMapping(value = "/getFamousMountains", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getFamousMountains(@RequestParam("pageNo") int pageNo) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getFamousMountains(pageNo));
        } catch (PageException e) {
            return ResponseUtil.exceptionError(CustomError.PAGE_UPPER_THAN_ZERO.code, CustomError.PAGE_UPPER_THAN_ZERO.message);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_TRAILS.code, CustomError.NO_TRAILS.message);
        }
    }

    @RequestMapping(value = "/getEducationProgram", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getEducationInfomation(@RequestParam("pageNo") int pageNo) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getEducationInfo(pageNo));
        } catch (PageException e) {
            return ResponseUtil.exceptionError(CustomError.PAGE_UPPER_THAN_ZERO.code, CustomError.PAGE_UPPER_THAN_ZERO.message);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_EDUCATION.code, CustomError.NO_EDUCATION.message);
        }
    }

    @RequestMapping(value = "/getAroundMountains", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getAroundMountains(@RequestParam("city") String city) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getAroundMountains(city));
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_AROUND_MOUNTAINS.code, CustomError.NO_AROUND_MOUNTAINS.message);
        }
    }

    @RequestMapping(value = "/getEasyMountains", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getEasyMountains(@RequestParam("pageNo") int pageNo) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getEasyMountains(pageNo));
        } catch (PageException e) {
            return ResponseUtil.exceptionError(CustomError.PAGE_UPPER_THAN_ZERO.code, CustomError.PAGE_UPPER_THAN_ZERO.message);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_EASY_MOUNTAINS.code, CustomError.NO_EASY_MOUNTAINS.message);
        }
    }

    @RequestMapping(value = "/getDifficultMountains", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getDifficultMountains(@RequestParam("pageNo") int pageNo) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getDifficultMountains(pageNo));
        } catch (PageException e) {
            return ResponseUtil.exceptionError(CustomError.PAGE_UPPER_THAN_ZERO.code, CustomError.PAGE_UPPER_THAN_ZERO.message);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_DIFFICULT_MOUNTAINS.code, CustomError.NO_DIFFICULT_MOUNTAINS.message);
        }
    }

    @RequestMapping(value = "/getMountainsWithBaby", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getMountainsWithBaby(@RequestParam("pageNo") int pageNo) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getMountainsWithBaby(pageNo));
        } catch (PageException e) {
            return ResponseUtil.exceptionError(CustomError.PAGE_UPPER_THAN_ZERO.code, CustomError.PAGE_UPPER_THAN_ZERO.message);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_MOUNTAINS_WITH_BABY.code, CustomError.NO_MOUNTAINS_WITH_BABY.message);
        }
    }

    @RequestMapping(value = "/getAutumnMountains", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getAutumnMountains(@RequestParam("pageNo") int pageNo) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getAutumnMountains(pageNo));
        } catch (PageException e) {
            return ResponseUtil.exceptionError(CustomError.PAGE_UPPER_THAN_ZERO.code, CustomError.PAGE_UPPER_THAN_ZERO.message);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_AUTUMN_MOUNTAINS.code, CustomError.NO_AUTUMN_MOUNTAINS.message);
        }
    }

    @RequestMapping(value = "/getPopularMountains", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getPopularMountains(@RequestParam("pageNo") int pageNo) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getPopularMountains(pageNo));
        } catch (PageException e) {
            return ResponseUtil.exceptionError(CustomError.PAGE_UPPER_THAN_ZERO.code, CustomError.PAGE_UPPER_THAN_ZERO.message);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_POPULAR_MOUNTAINS.code, CustomError.NO_POPULAR_MOUNTAINS.message);
        }
    }

    @RequestMapping(value = "/getVallyMountains", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getVallyMountains(@RequestParam("pageNo") int pageNo) {
        try {
            return ResponseUtil.success(mountainServiceImpl.getVallyMountains(pageNo));
        } catch (PageException e) {
            return ResponseUtil.exceptionError(CustomError.PAGE_UPPER_THAN_ZERO.code, CustomError.PAGE_UPPER_THAN_ZERO.message);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_VALLY_MOUNTAINS.code, CustomError.NO_VALLY_MOUNTAINS.message);
        }
    }
}
