package com.coocaa.springBoot.exception;


import com.coocaa.springBoot.enums.BaseEnum;
import com.coocaa.springBoot.enums.ResultEnum;

public class UserException extends RuntimeException{

    private Integer code;

    public UserException() {
    }

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public UserException(BaseEnum baseEnum) {
        super(baseEnum.getMsg());
        this.code = baseEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
