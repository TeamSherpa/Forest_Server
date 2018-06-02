package com.sherpa.mapper;

import com.sherpa.v1.mountain.MountainDTO;
import com.sherpa.v1.mountain.MountainImageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MountainMapper {
    void add(MountainDTO mountainDTO);
    void updateImage(MountainImageDTO mountainImageDTO);
}
