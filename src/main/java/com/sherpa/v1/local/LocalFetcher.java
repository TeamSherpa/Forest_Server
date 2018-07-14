package com.sherpa.v1.local;

import com.google.gson.*;
import com.sherpa.network.APIConfiguration;
import com.sherpa.network.NetworkRequestor;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalFetcher {

    public static List<LocalDTO> request(String searchText) throws Exception {
        String enc = "UTF-8";
        String encodedText = URLEncoder.encode(searchText, enc);
        String path = "https://openapi.naver.com/v1/search/local.json?query=" + encodedText;
        String method = "GET";
        NetworkRequestor requestor = new NetworkRequestor(path, method);
        Map<String, String> naverKey = new HashMap<>();
        naverKey.put("X-Naver-Client-Id", APIConfiguration.naver_ID);
        naverKey.put("X-Naver-Client-Secret", APIConfiguration.naver_Secret);
        requestor.connect(naverKey);

        String jsonData = requestor.getOutputStream();
        JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
        JsonArray jsonElements = jsonObject.get("items").getAsJsonArray();
        List<LocalDTO> localDTOList = new ArrayList<>();
        for(JsonElement element: jsonElements) {
            LocalDTO localDTO = new Gson().fromJson(element, LocalDTO.class);
            localDTOList.add(localDTO);
        }
        return localDTOList;
    }
}
