package com.xupt.common.aspect;

import com.alibaba.fastjson.JSON;
import com.xupt.common.annotation.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Slf4j  // 记忆技巧 酸辣粉4j
public class LogAspect {

    // 定义切点 通过注解、切入点表达式 确定切点
    @Pointcut("@annotation(com.xupt.common.annotation.SystemLog)")
    public void pt(){

    }

    @Around("pt()") // 指定切点

    // joinPoint  指的是被增强方法的信息封装出来的对象
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object ret;
        try {
            handleBefore(joinPoint);    // 调用之前进行处理
            ret = joinPoint.proceed();  // 目标方法的调用
            handleAfter(ret);			// 调用之后进行处理
        } finally {
            log.info("=======End=======" + System.lineSeparator());
        }
        return ret; // 返回目标方法的返回值
    }

    private void handleBefore(ProceedingJoinPoint joinPoint) {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        SystemLog systemlog=getSystemLog(joinPoint);

        log.info("=======Start=======");
        // 打印请求 URL
        log.info("URL            : {}",request.getRequestURL());
        // 打印描述信息
        log.info("BusinessName   : {}", systemlog.businessName());
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}",joinPoint.getSignature().getDeclaringTypeName(),((MethodSignature)joinPoint.getSignature()).getName());
        // 打印请求的 IP
        log.info("IP             : {}",request.getRemoteHost());
        // 打印请求入参
        log.info("Request Args   : {}", JSON.toJSONString(joinPoint.getArgs()));
    }

    private SystemLog getSystemLog(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        SystemLog sys = methodSignature.getMethod().getAnnotation(SystemLog.class);
        return sys;
    }

    private void handleAfter(Object ret) {
        // 打印出参
        log.info("Response       : {}",JSON.toJSONString(ret));

    }
}
