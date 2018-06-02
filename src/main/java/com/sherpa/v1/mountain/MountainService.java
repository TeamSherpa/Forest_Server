package com.sherpa.v1.mountain;

import com.sherpa.mountain.parse.MountainImage;
import org.springframework.stereotype.Service;

@Service
public interface MountainService {
    void add(MountainDTO mountainDTO);
    void updateImage(MountainImageDTO mountainImageDTO);
}
