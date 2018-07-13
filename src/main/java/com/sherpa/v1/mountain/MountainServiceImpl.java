package com.sherpa.v1.mountain;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sherpa.exception.CustomError;
import com.sherpa.mapper.MountainMapper;
import com.sherpa.mountain.parse.MountainInformationParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

@Service
public class MountainServiceImpl implements MountainService {

    @Autowired
    private MountainMapper mountainMapper;

    @Override
    public void add(MountainDTO mountainDTO) {
        mountainMapper.add(mountainDTO);
    }

    @Override
    public void updateImage(MountainImageDTO mountainImageDTO) {
        mountainMapper.updateImage(mountainImageDTO);
    }

    @Override
    public HashMap<String, Object> getTrailInfo(String code) throws Exception {
        String path = "/home/ec2-user/forest_server/Forest_Server/trails/" + code + ".json";
        JsonObject object = (JsonObject) new JsonParser().parse(new FileReader(path));
        HashMap<String, Object> map = new HashMap<String,Object>();
        map = (HashMap<String,Object>) new Gson().fromJson(object, map.getClass());
        return map;
    }

    @Override
    public void updateFamous(FamousMountainDTO famousMountainDTO) {
        mountainMapper.updateFamous(famousMountainDTO);
    }

    @Override
    public List<MountainDTO> getFamousMountains(int pageNo) throws Exception {
        if (pageNo == 0) {
            throw CustomError.PAGE_UPPER_THAN_ZERO.exception();
        }
        int size = (pageNo - 1) * 10;
        return mountainMapper.getFamousMountains(size);
    }

    public List<ForestEducationDTO> getEducationInfo(int pageNo) throws Exception {
        if (pageNo == 0) {
            throw CustomError.PAGE_UPPER_THAN_ZERO.exception();
        }
        return MountainInformationParse.shared.fetchEducationInfo(pageNo);
    }

    @Override
    public List<MountainDTO> getAroundMountains(String city, int pageNo) throws Exception {
        if (pageNo == 0) {
            throw CustomError.PAGE_UPPER_THAN_ZERO.exception();
        }
        int size = (pageNo - 1) * 10;
        return mountainMapper.getAroundMountains(city, size);
    }

    @Override
    public List<MountainDTO> getEasyMountains(int pageNo) throws Exception {
        if (pageNo == 0) {
            throw CustomError.PAGE_UPPER_THAN_ZERO.exception();
        }
        int size = (pageNo - 1) * 10;
        return mountainMapper.getEasyMountains(size);
    }

    public String getMountainCode(String name) throws Exception {
        if (name.isEmpty()) {
            throw new Exception();
        }
        return mountainMapper.getMountainCode(name);
    }

    public String getCity(String name) throws Exception {
        if (name.isEmpty()) {
            throw new Exception();
        }
        return mountainMapper.getCity(name);
    }

    public List<MountainDTO> getDifficultMountains(int pageNo) throws Exception {
        if (pageNo == 0) {
            throw CustomError.PAGE_UPPER_THAN_ZERO.exception();
        }
        int size = (pageNo - 1) * 10;
        return mountainMapper.getDifficultMountains(size);
    }

    public List<MountainDTO> getMountainsWithBaby(int pageNo) throws Exception {
        if (pageNo == 0) {
            throw CustomError.PAGE_UPPER_THAN_ZERO.exception();
        }
        int size = (pageNo - 1) * 10;
        return mountainMapper.getMountainsWithBaby(size);
    }

    public List<MountainDTO> getAutumnMountains(int pageNo) throws Exception {
        if (pageNo == 0) {
            throw CustomError.PAGE_UPPER_THAN_ZERO.exception();
        }
        int size = (pageNo - 1) * 10;
        return mountainMapper.getAutumnMountains(size);
    }

    public List<MountainDTO> getPopularMountains(int pageNo) throws Exception {
        if (pageNo == 0) {
            throw CustomError.PAGE_UPPER_THAN_ZERO.exception();
        }
        int size = (pageNo - 1) * 10;
        return mountainMapper.getPopularMountains(size);
    }

    @Override
    public List<MountainDTO> getVallyMountains(int pageNo) throws Exception {
        if (pageNo == 0) {
            throw CustomError.PAGE_UPPER_THAN_ZERO.exception();
        }
        int size = (pageNo - 1) * 10;
        return mountainMapper.getVallyMountains(size);
    }

    @Override
    public List<MountainPositionDTO> getMountainPosition(String code) {
        return mountainMapper.getMountainPosition(code);
    }
}
