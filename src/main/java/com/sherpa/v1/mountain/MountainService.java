package com.sherpa.v1.mountain;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface MountainService {
    void add(MountainDTO mountainDTO);
    void updateImage(MountainImageDTO mountainImageDTO);
    HashMap<String, Object> getTrailInfo(String code) throws Exception;
    void updateFamous(FamousMountainDTO famousMountainDTO);
    List<MountainDTO> getFamousMountains(int size) throws Exception;
    List<ForestEducationDTO> getEducationInfo(int pageNo) throws Exception;
    List<MountainDTO> getAroundMountains(String city) throws Exception;
    List<MountainDTO> getEasyMountains(int size) throws Exception;
    String getMountainCode(String name) throws Exception;
    String getCity(String name) throws Exception;
    List<MountainDTO> getDifficultMountains(int size) throws Exception;
    List<MountainDTO> getMountainsWithBaby(int size) throws Exception;
    List<MountainDTO> getAutumnMountains(int size) throws Exception;
    List<MountainDTO> getPopularMountains(int pageNo) throws Exception;
    List<MountainDTO> getVallyMountains(int pageNo) throws Exception;
}
