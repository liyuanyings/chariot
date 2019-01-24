package com.example.base.common.result;

import com.example.base.common.enums.IEnum;

import java.io.Serializable;

public class BaseResult implements Serializable {

    private static final long serialVersionUID = 1638693422783183022L;

    private String retcode;

    private String retmsg;

    private Object data;

    public static Builder success(){
        return new Builder(EBaseResult.SUCCESS);
    }

    public static Builder error(){
        return new Builder(EBaseResult.FAILED);
    }

    public static Builder error(IEnum result){
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

        private Builder(IEnum result){
            this.retcode = (String) result.getCode();
            this.retmsg = result.getDescription();
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

        public BaseResult build() {
            BaseResult response = new BaseResult();
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
