package com.example.base.common.result;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 1638693422783183022L;

    private String retcode;

    private String retmsg;

    private Object data;

    public static Builder success(){
        return new Builder(EResult.SUCCESS);
    }

    public static Builder error(){
        return new Builder(EResult.FAILED);
    }

    public static Builder error(IResult result){
        return new Builder(result);
    }


    /**
     * Nested classes are divided into two categories: static and non-static.
     * Nested classes that are declared static are called static nested classes.
     * Non-static nested classes are called inner classes.
     */
    public static final class Builder {

        private String retcode;

        private String retmsg;

        private Object data;

        private Builder() {
        }

        private Builder(IResult result){
            this.retcode = result.retcode();
            this.retmsg = result.retmsg();
        }

        public Builder retcode(String retcode) {
            this.retcode = retcode;
            return this;
        }

        public Builder retmsg(String retmsg) {
            this.retmsg = retmsg;
            return this;
        }

        public Builder data(Object data) {
            this.data = data;
            return this;
        }

        public BaseResponse build() {
            BaseResponse response = new BaseResponse();
            response.retcode = this.retcode;
            response.retmsg = this.retmsg;
            response.data = this.data;

            return response;
        }
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
