package com.sherpa.v1.local;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalServiceImpl implements LocalService {

    @Override
    public List<LocalDTO> getLocal(String searchText) throws Exception {
        return LocalFetcher.request(searchText);
    }
}

