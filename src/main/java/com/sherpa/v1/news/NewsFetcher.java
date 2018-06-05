package com.sherpa.v1.news;

import com.google.gson.*;
import com.sherpa.network.APIConfiguration;
import com.sherpa.network.NetworkRequestor;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsFetcher {

    public static List<NewsDTO> request(String searchText) throws Exception {
        String enc = "UTF-8";
        String encodedText = URLEncoder.encode(searchText, enc);
        String path = "https://openapi.naver.com/v1/search/news.json?query=" + encodedText;
        String method = "GET";
        NetworkRequestor requestor = new NetworkRequestor(path, method);
        Map<String, String> naverKey = new HashMap<>();
        naverKey.put("X-Naver-Client-Id", APIConfiguration.naver_ID);
        naverKey.put("X-Naver-Client-Secret", APIConfiguration.naver_Secret);
        requestor.connect(naverKey);

        String jsonData = requestor.getOutputStream();
        JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
        JsonArray jsonElements = jsonObject.get("items").getAsJsonArray();
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for(JsonElement element: jsonElements) {
            NewsDTO newsDTO = new Gson().fromJson(element, NewsDTO.class);
            newsDTOList.add(newsDTO);
        }
        return newsDTOList;
    }
}
