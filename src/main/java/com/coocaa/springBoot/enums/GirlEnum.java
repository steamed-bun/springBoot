package com.coocaa.springBoot.enums;

public enum  GirlEnum implements BaseEnum{

    PRIMARY_SCHOOL(100,"你已经是一个帅气的女孩子啦..."),
    MIDDLE_SCHOOL(200,"何不去剪一个纯粹的圆寸^_^..."),
    UNKNOW(-1,"未知错误"),
    SUCCESS(1,"成功啦~")
            ;

    private Integer code;
    private String msg;

    private GirlEnum(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
