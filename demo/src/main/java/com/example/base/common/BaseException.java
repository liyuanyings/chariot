package com.example.base.common;

public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 315269926261468007L;

    private String code;

    private String message;

    public BaseException(){
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
