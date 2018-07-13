package com.sherpa.mapper;

import com.sherpa.v1.mountain.FamousMountainDTO;
import com.sherpa.v1.mountain.MountainDTO;
import com.sherpa.v1.mountain.MountainImageDTO;
import com.sherpa.v1.mountain.MountainPositionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MountainMapper {
    void add(MountainDTO mountainDTO);
    void updateImage(MountainImageDTO mountainImageDTO);
    void updateFamous(FamousMountainDTO famousMountainDTO);
    List<MountainDTO> getFamousMountains(int pageNo);
    List<MountainDTO> getAroundMountains(@Param("city") String city, @Param("pageNo") int pageNo);
    List<MountainDTO> getEasyMountains(int pageNo);
    String getMountainCode(String name);
    String getCity(String name);
    List<MountainDTO> getDifficultMountains(int pageNo);
    List<MountainDTO> getMountainsWithBaby(int size);
    List<MountainDTO> getAutumnMountains(int size);
    List<MountainDTO> getPopularMountains(int pageNo);
    List<MountainDTO> getVallyMountains(int pageNo);
    List<MountainPositionDTO> getMountainPosition(String code);
}
