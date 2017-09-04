package com.coocaa.springBoot.enums;

public enum ResultEnum implements BaseEnum{


    PRIMARY_SCHOOL(100,"你已经是一个漂亮的蓝孩子啦..."),
    MIDDLE_SCHOOL(200,"何不画上漂亮的眼影^_^..."),
    UNKNOW(-1,"未知错误")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
