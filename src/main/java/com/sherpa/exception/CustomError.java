package com.sherpa.exception;

public enum CustomError {

    NO_TRAILS(2000, "등산로를 제공하지 않습니다."),
    NO_FAMOUS_MOUNTAINS(2001, "유명 산 API 에러"),
    NO_EDUCATION(2001, "산림 교육 프로그램 OPEN API 에러"),
    NO_EASY_MOUNTAINS(2001, "등산하기 쉬운 산 API 에러"),
    NO_DIFFICULT_MOUNTAINS(2001, "등산하기 어려운 산 API 에러"),
    NO_MOUNTAINS_WITH_BABY(2001, "아이와 함께 가기 좋은 산 API 에러"),
    NO_POPULAR_MOUNTAINS(2001, "인기 좋은 산 API 에러"),
    NO_VALLY_MOUNTAINS(2001, "계곡 있는 산 API 에러"),
    NO_AUTUMN_MOUNTAINS(2001, "가을에 가기 좋은 산 API 에러"),
    NEWS_API_ERROR(2001, "뉴스 OPEN API 에러"),
    NO_AROUND_MOUNTAINS(2001, "주변 산 API 에러"),
    VOICE_INPUT_API_ERROR(2001, "음성 인식 API 에러"),
    PAGE_UPPER_THAN_ZERO(2002, "페이지는 1부터 시작해야합니다."),
    CANNOT_PROCESSING_VOICE_INPUT(2003, "음성 처리를 할 수 없습니다."),
    NO_HOURLY_WEATHER(2001, "시간별 날씨 OPEN API 에러"),
    URL_ENCODING_ERROR(2004, "URL 인코딩 에러"),
    NO_YESTERDAY_WEATHER(2001, "어제 날씨 OPEN API 에러"),
    NO_WEATHER_SPECIAL_REPORT(2001, "기상특보 OPEN API 에러"),
    NO_UV_INDEX_ERROR(2001, "자외선 지수 OPEN API 에러"),
    NO_MOUNTAIN_IN_DB(2005, "해당 산이 DB에 없음");

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