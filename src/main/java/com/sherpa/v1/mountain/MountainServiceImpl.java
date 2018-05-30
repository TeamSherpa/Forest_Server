package com.sherpa.v1.mountain;

import com.sherpa.mapper.MountainMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MountainServiceImpl implements MountainService {

    @Autowired
    private MountainMapper mountainMapper;

    public void add(MountainDTO mountainDTO) {
        mountainMapper.add(mountainDTO);
    }
}
