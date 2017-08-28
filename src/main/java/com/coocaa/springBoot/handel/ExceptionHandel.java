package com.coocaa.springBoot.handel;

import com.coocaa.springBoot.domain.Result;
import com.coocaa.springBoot.exception.UserException;
import com.coocaa.springBoot.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandel {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandel.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handel(Exception e){

        if (e instanceof UserException){
            UserException userException = (UserException) e;
            return ResultUtil.error(userException.getCode(), userException.getMessage());
        }
        logger.error("系统异常={}", e);
        return ResultUtil.error(-1,"未知错误");
    }

}
