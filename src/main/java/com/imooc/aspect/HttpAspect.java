package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/22 0022.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger loger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        //url
        loger.info("url={}",request.getRequestURL());

        //method
        loger.info("method={}",request.getMethod());

        //ip
        loger.info("ip={}",request.getRemoteAddr());

        //类方法
        loger.info("class_method={}",joinPoint.getSignature().getDeclaringType()+" : "+joinPoint.getSignature().getName());

        loger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        loger.info("atAfter");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
//        loger.info("response={}",object.toString());
    }
}
