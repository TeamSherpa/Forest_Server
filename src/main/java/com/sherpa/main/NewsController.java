package com.sherpa.main;

import com.sherpa.exception.CustomError;
import com.sherpa.network.ResponseUtil;
import com.sherpa.v1.news.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class NewsController {

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    @RequestMapping(value = "/getNews", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getEducationInfomation(@RequestParam("searchText") String searchText) {
        try {
            return ResponseUtil.success(newsServiceImpl.getNews(searchText));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.exceptionError(CustomError.NEWS_API_ERROR.code, CustomError.NEWS_API_ERROR.message);
        }
    }
}
