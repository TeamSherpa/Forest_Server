package com.sherpa.v1.mountain;

import com.google.gson.JsonObject;
import com.sherpa.mountain.parse.MountainImage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface MountainService {
    void add(MountainDTO mountainDTO);
    void updateImage(MountainImageDTO mountainImageDTO);
    HashMap<String, Object> getTrailInfo(String code) throws Exception;
    void updateFamous(FamousMountainDTO famousMountainDTO);
    List<MountainDTO> getFamousMountains();
}
