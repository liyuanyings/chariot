package com.example.demo.common;

/**
 * @program: web
 * @description:
 * @author: WT1124
 * @create: 2018-08-27 16:06
 **/
public class CustomizeRuntimeException extends RuntimeException{

    private static final long serialVersionUID = 315269926261468007L;

    private String code;

    private String message;

    public CustomizeRuntimeException(){
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
