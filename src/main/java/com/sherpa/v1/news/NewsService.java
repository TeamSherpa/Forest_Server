package com.sherpa.v1.news;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    List<NewsDTO> getNews(String searchText) throws Exception;
}
