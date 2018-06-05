package com.sherpa.main;

import com.sherpa.network.CustomError;
import com.sherpa.network.ResponseUtil;
import com.sherpa.v1.news.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NewsController {

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    @RequestMapping("/getNews/searchText={text}")
    public Map<String, Object> getEducationInfomation(@PathVariable("text") String searchText) {
        try {
            return ResponseUtil.success(newsServiceImpl.getNews(searchText));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.exceptionError(CustomError.NEWS_API_ERROR.code, CustomError.NEWS_API_ERROR.message);
        }
    }
}
