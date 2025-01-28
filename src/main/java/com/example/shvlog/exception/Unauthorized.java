package com.example.shvlog.exception;

public class Unauthorized extends ShvlogException{

    private static final String MESSAGE = "인증이 필요합니다.";

    public Unauthorized() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 401;
    }


}
