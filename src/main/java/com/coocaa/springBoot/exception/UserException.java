package com.coocaa.springBoot.exception;


public class UserException extends RuntimeException{

    private Integer code;

    public UserException() {
    }

    public UserException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
