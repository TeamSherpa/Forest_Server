package com.sherpa.v1.news;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Override
    public List<NewsDTO> getNews(String searchText) throws Exception {
        return NewsFetcher.request(searchText);
    }
}

