package com.sherpa.exception;

public enum CustomError {

    NO_TRAILS(2000, "등산로를 제공하지 않습니다."),
    NO_FAMOUS_MOUNTAINS(2001, "유명 산 API 에러"),
    No_EDUCATION(2002, "산림 교육 프로그램 OPEN API 에러"),
    NEWS_API_ERROR(2003, "뉴스 OPEN API 에러"),
    NO_AROUND_MOUNTAINS(2004, "주변 산 API 에러"),
    PAGE_UPPER_THAN_ZERO(2005, "페이지는 1부터 시작해야합니다.");

    public int code;
    public String message;

    CustomError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Exception exception() {
        switch (this) {
            case PAGE_UPPER_THAN_ZERO: return new PageException();
            default: return new Exception();
        }
    }
}