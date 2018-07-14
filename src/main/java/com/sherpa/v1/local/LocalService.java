package com.sherpa.v1.local;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocalService {
    List<LocalDTO> getLocal(String searchText) throws Exception;
}
