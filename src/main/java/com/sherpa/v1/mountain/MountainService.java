package com.sherpa.v1.mountain;

import org.springframework.stereotype.Service;

@Service
public interface MountainService {
    void add(MountainDTO mountainDTO);
}
