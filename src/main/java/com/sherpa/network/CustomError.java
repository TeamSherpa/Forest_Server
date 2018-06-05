package com.sherpa.network;

public enum CustomError {

    NO_TRAILS(2000, "등산로를 제공하지 않습니다."),
    No_EDUCATION(2001, "산림 교육 프로그램 OPEN API 에러"),
    NEWS_API_ERROR(2002, "뉴스 OPEN API 에러");

    public int code;
    public String message;

    CustomError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}