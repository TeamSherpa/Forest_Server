package com.sherpa.ai;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sherpa.exception.CustomError;
import com.sherpa.network.NetworkRequestor;
import com.sherpa.network.ResponseUtil;
import com.sherpa.v1.local.LocalServiceImpl;
import com.sherpa.v1.mountain.MountainDTO;
import com.sherpa.v1.mountain.MountainServiceImpl;
import com.sherpa.v1.news.NewsServiceImpl;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoiceInputProcessor {

    String openSourceUrl = "https://open-korean-text.herokuapp.com/extractPhrases?text=";
    String method = "GET";
    NetworkRequestor networkRequestor;
    List<String> phrasePool = new ArrayList<>();
    String mountainName;
    String input;

    public VoiceInputProcessor(String input) throws Exception {
        this.input = input;
        String enc = "UTF-8";
        openSourceUrl += URLEncoder.encode(input, enc);
        this.networkRequestor = new NetworkRequestor(openSourceUrl, method);
        networkRequestor.connect();
        extractPhrase();
    }

    private void extractPhrase() throws Exception {
        String result = networkRequestor.getOutputStream();
        JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
        JsonArray phrases = jsonObject.get("phrases").getAsJsonArray();
        for (JsonElement element: phrases) {
            phrasePool.add(element.toString().substring(1, element.toString().indexOf("(")));
        }

        for (String phrase: phrasePool) {
            if (phrase.contains("산")) {
                mountainName = phrase;
                break;
            }
        }
    }

    public Map<String, Object> process(NewsServiceImpl newsService, MountainServiceImpl mountainService, LocalServiceImpl localService) throws Exception {
        Category category = Category.getCategory(phrasePool);
        Map<String, Object> result = new HashMap<>();
        result.put("Category", category);
        switch (category) {
            case NEWS:
                result.put("response", newsService.getNews(input));
                return ResponseUtil.success(result);
            case WEATHER:
                break;
            case EDUCATION:
                result.put("response", mountainService.getEducationInfo(1));
                return ResponseUtil.success(result);
            case MOUNTAIN:
                result.put("response", subdivideMountainCategory(mountainService));
                return ResponseUtil.success(result);
            case TRAIL:
                String code = mountainService.getMountainCode(mountainName);
                result.put("response", mountainService.getTrailInfo(code));
                return ResponseUtil.success(result);
            case TRAFFIC:
                String mountainCode = mountainService.getMountainCode(mountainName);
                result.put("response", mountainService.getMountainPosition(mountainCode));
                return ResponseUtil.success(result);
            case LOCAL:
                String searchText = mountainName + "맛집";
                result.put("response", localService.getLocal(searchText));
                return ResponseUtil.success(result);
            case INFO:
                result.put("response", mountainService.getMountainInfo(mountainName));
                return ResponseUtil.success(result);
            case DISTANCE:
                Map<String, Object> distanceMap = new HashMap<>();
                distanceMap.put("distance", "2.4");
                result.put("response", distanceMap);
                return ResponseUtil.success(distanceMap);
            case NONE:
                break;
        }
        return ResponseUtil.exceptionError(CustomError.CANNOT_PROCESSING_VOICE_INPUT.code, CustomError.CANNOT_PROCESSING_VOICE_INPUT.message);
    }

    private Object subdivideMountainCategory(MountainServiceImpl service) throws Exception {
        for (String pharse: phrasePool) {
            if (pharse.contains("쉬운") || pharse.contains("편한") || pharse.contains("낮은")) {
                return service.getEasyMountains(1);
            } else if (pharse.contains("등산로")) {

            } else if (pharse.contains("유명") || pharse.contains("명산") || pharse.contains("유명한")) {
                return service.getFamousMountains(1);
            } else if (pharse.contains("가을") || pharse.contains("단풍")) {
                return service.getAutumnMountains(1);
            } else if (pharse.contains("아이")) {
                return service.getMountainsWithBaby(1);
            } else if (pharse.contains("계곡")) {
                return service.getVallyMountains(1);
            } else if (pharse.contains("인기")) {
                return service.getPopularMountains(1);
            } else if (pharse.contains("어려운 산") || pharse.contains("높은 산")) {
                return service.getDifficultMountains(1);
            }
        }
        throw new Exception();
    }
}
