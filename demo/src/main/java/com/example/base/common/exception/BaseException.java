package com.example.base.common.exception;

import com.example.base.common.result.EBaseResult;

public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 315269926261468007L;

    private String retcode;

    private String retmsg;

    public BaseException(){
        super();
    }

    public BaseException(Throwable throwable) {
        super(throwable);
        this.retcode = EBaseResult.SERVER_ERROR.getCode();
        this.retmsg = EBaseResult.SERVER_ERROR.getDescription();
    }

    public BaseException(String message){
        super(message);
        this.retcode = EBaseResult.SERVER_ERROR.getCode();
        this.retmsg = message;
    }

    public BaseException(String message, Throwable throwable){
        super(message, throwable);
        this.retcode = EBaseResult.SERVER_ERROR.getCode();
        this.retmsg = message;
    }

    public BaseException(String code, String message) {
        super(message);
        this.retcode = code;
        this.retmsg = message;
    }

    public BaseException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.retcode = code;
        this.retmsg = message;
    }

    public String getRetcode() {
        return retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }
}
