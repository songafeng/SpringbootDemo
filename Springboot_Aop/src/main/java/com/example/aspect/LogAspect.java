package com.example.aspect;

/**
 * Created by jdd on 2019/12/31.
 */

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * 前置增强：目标方法执行之前执行
     *
     * @param jp
     */
    @Before("execution(* com.example.controller.*.*(..))") // 所有controller包下面的所有方法的所有参数
    public void beforeMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        log.info("【前置增强】the method 【" + methodName + "】 begins with " + JSON.toJSONString(jp.getArgs()));
    }

    /**
     * 后置增强：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
     *
     * @param jp
     */
    @After("execution(* com.example.controller.*.*(..)))")
    public void afterMethod(JoinPoint jp) {
        log.info("【后置增强】this is a afterMethod advice...");
    }

    /**
     * 返回增强：目标方法正常执行完毕时执行
     *
     * @param jp
     * @param result
     */
    @AfterReturning(value = "execution(* com.example.controller.*.*(..)))", returning = "result")
    public void afterReturningMethod(JoinPoint jp, Object result) {
        String methodName = jp.getSignature().getName();
        log.info("【返回增强】the method 【" + methodName + "】 ends with 【" + result + "】");
    }

    /**
     * 异常增强：目标方法发生异常的时候执行，第二个参数表示补货异常的类型
     *
     * @param jp
     * @param e
     */
    @AfterThrowing(value = "execution(* com.example.controller.*.*(..))", throwing = "e")
    public void afterThorwingMethod(JoinPoint jp, Exception e) {
        String methodName = jp.getSignature().getName();
        log.error("【异常增强】the method 【" + methodName + "】 occurs exception: ", e);
    }

    /**
     * 环绕增强：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     *
     * @return
     */
/*    @Around(value = "execution(* com.example.com.example.controller.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Object result = null;
        try {
            log.info("【环绕增强中的--->前置增强】：the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
            //执行目标方法
            result = jp.proceed();
            log.info("【环绕增强中的--->返回增强】：the method 【" + methodName + "】 ends with " + result);
        } catch (Throwable e) {
            result = "error";
            log.info("【环绕增强中的--->异常增强】：the method 【" + methodName + "】 occurs exception " + e);
        }
        log.info("【环绕增强中的--->后置增强】：-----------------end.----------------------");
        return result;
    }*/
}