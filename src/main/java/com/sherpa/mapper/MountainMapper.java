package com.sherpa.mapper;

import com.sherpa.v1.mountain.FamousMountainDTO;
import com.sherpa.v1.mountain.MountainDTO;
import com.sherpa.v1.mountain.MountainImageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MountainMapper {
    void add(MountainDTO mountainDTO);
    void updateImage(MountainImageDTO mountainImageDTO);
    void updateFamous(FamousMountainDTO famousMountainDTO);
    List<MountainDTO> getFamousMountains(int pageNo);
    List<MountainDTO> getAroundMountains(String city);
    List<MountainDTO> getEasyMountains(int pageNo);
}
