package com.sherpa.ai;

import java.util.List;

public enum Category {

    NONE,
    NEWS,
    MOUNTAIN,
    EDUCATION,
    WHETHER;


    public static Category getCategory(List<String> phrases) {
        if (phrases.contains("뉴스")) {
            return Category.NEWS;
        } else if (phrases.contains("교육") || phrases.contains("프로그램")) {
            return Category.EDUCATION;
        } else if (phrases.contains("날씨") || phrases.contains("기상")) {
            return Category.WHETHER;
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