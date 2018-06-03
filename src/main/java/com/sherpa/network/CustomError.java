package com.sherpa.network;

public enum CustomError {

    NO_TRAILS(2000, "등산로를 제공하지 않습니다.");

    public int code;
    public String message;

    CustomError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}