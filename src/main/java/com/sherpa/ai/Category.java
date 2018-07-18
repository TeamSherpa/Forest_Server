package com.sherpa.ai;

import java.util.List;

public enum Category {

    NONE,
    NEWS,
    MOUNTAIN,
    EDUCATION,
    TRAIL,
    TRAFFIC,
    LOCAL,
    WEATHER,
    INFO;


    public static Category getCategory(List<String> phrases) {
        if (phrases.contains("뉴스")) {
            return Category.NEWS;
        } else if (phrases.contains("교육") || phrases.contains("프로그램")) {
            return Category.EDUCATION;
        } else if (phrases.contains("날씨") || phrases.contains("기상")) {
            return Category.WEATHER;
        } else if (phrases.contains("등산로")) {
            return Category.TRAIL;
        } else if (phrases.contains("교통") || phrases.contains("경로")) {
            return Category.TRAFFIC;
        } else if (phrases.contains("맛집") || phrases.contains("음식점")) {
            return Category.LOCAL;
        } else if (phrases.contains("정보")) {
            return Category.INFO;
        } else {
            for (String phrase: phrases) {
                if (phrase.contains("산")) {
                    return Category.MOUNTAIN;
                }
            }
            return Category.NONE;
        }
    }
}