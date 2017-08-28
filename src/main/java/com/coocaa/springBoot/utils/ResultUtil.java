package com.coocaa.springBoot.utils;

import com.coocaa.springBoot.domain.Result;

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

}
