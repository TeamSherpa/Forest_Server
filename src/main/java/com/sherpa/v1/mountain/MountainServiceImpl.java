package com.sherpa.v1.mountain;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sherpa.mapper.MountainMapper;
import com.sherpa.mountain.parse.MountainInfomationParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        System.out.print(MountainServiceImpl.class.getResource("").getPath());
        String path = MountainServiceImpl.class.getResource("").getPath() + "trails/" + code + ".json";
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
    public List<MountainDTO> getFamousMountains() throws Exception {
        return mountainMapper.getFamousMountains();
    }

    public List<ForestEducationDTO> getEducationInfo(int pageNo) throws Exception {
        return MountainInfomationParse.shared.fetchEducationInfo(pageNo);
    }
}
