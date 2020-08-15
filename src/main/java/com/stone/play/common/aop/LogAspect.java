package com.stone.play.common.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


/**
 * LogAspect
 */
@Aspect
@Component
public class LogAspect {
	
	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    
    @Around("execution(* com.stone.play.*.controller.*.*(..))")
    public Object controllerLog(ProceedingJoinPoint pjp) throws Throwable {
        log.info("#################################################################################");
        log.info("@[LogAspect : Start] - {}/{}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName());
        long startTime = System.currentTimeMillis();
        
        Object[] signatureArgs = pjp.getArgs();
        for (Object signatureArg : signatureArgs) {
            this.printJsonFormatParamLog(pjp, signatureArg);
        }
        
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        log.info("@{} took {} seconds", pjp.getSignature().getName(), TimeUnit.MILLISECONDS.toSeconds(endTime - startTime));
        log.info("@[LogAspect : End] - {}/{}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName());
        log.info("#################################################################################");
        return result;
    }
    
    
    /**
     * print controller, service method params in json format
     * 
     * @param pjp, arg
     * @throws JsonProcessingException
     */
    public void printJsonFormatParamLog(ProceedingJoinPoint pjp, Object arg) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.info("@Request [{}]'s parameters are\r\n # {} #", pjp.getSignature().getName(), !StringUtils.isBlank(gson.toJson(arg)) ? gson.toJson(arg) : "Empty");
    }


}
