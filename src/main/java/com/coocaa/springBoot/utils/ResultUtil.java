package com.coocaa.springBoot.utils;

import com.coocaa.springBoot.domain.Result;
import com.coocaa.springBoot.enums.BaseEnum;

public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("SUCCESS");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result success(BaseEnum baseEnum,Object object){
        Result result = new Result();
        result.setCode(baseEnum.getCode());
        result.setMsg(baseEnum.getMsg());
        result.setData(object);
        return result;
    }

    public static Result error(BaseEnum baseEnum){
        Result result = new Result();
        result.setCode(baseEnum.getCode());
        result.setMsg(baseEnum.getMsg());
        result.setData(null);
        return result;
    }

}
