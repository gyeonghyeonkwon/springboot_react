package com.ll.react_spring.global.Exception;

public class GlobalException extends RuntimeException{

    public GlobalException(String resultCode, String msg) {
        super("resultCode=" + resultCode + ",msg=" + msg);
    }
}
