package com.coocaa.springBoot.aspect;

import com.coocaa.springBoot.utils.ResultUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Aspect
@Component
public class JSRAspect {

    private final static Logger logger = LoggerFactory.getLogger(JSRAspect.class);

    @Pointcut(value = "execution(public * com.coocaa.springBoot.controller.*.*(..))" )
    public void validated(){
    }


    @Around(value = "validated()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        BindingResult result = null;
        Object[] objects = joinPoint.getArgs();
        if (objects != null && objects.length > 0){
            for (Object o : objects){
                if (o instanceof BindingResult){
                    result = (BindingResult) o;
                    break;
                }
            }
        }
        if (result != null && result.hasErrors()){
            FieldError fieldError = result.getFieldError();
            String method = joinPoint.getSignature().getName();
            String targetName = joinPoint.getTarget().getClass().getName();
            logger.info("参数验证出错: 类控制器{}, 方法{}, 参数{}, 属性:{}, 错误:{}, 消息:{}",
                    targetName, method, fieldError.getObjectName(), fieldError.getField(),
                    fieldError.getCode(), fieldError.getDefaultMessage());
            return ResultUtil.error(101003, fieldError.getDefaultMessage());
        }
        return joinPoint.proceed();
    }


}
