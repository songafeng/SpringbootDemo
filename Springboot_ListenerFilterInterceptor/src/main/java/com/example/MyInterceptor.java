package com.example;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    //在请求处理之前进行调用（Controller方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        System.out.println("MyInterceptor:preHandle被调用");

        if(handler instanceof HandlerMethod) {
            HandlerMethod h = (HandlerMethod)handler;
            Long startTime = System.currentTimeMillis();
            httpServletRequest.setAttribute("startTime", startTime);
            //获取控制器的名字
            System.out.println(h.getBean().getClass().getName());
            //获取方法名
            System.out.println(h.getMethod().getName());
        }

//        获取@PathVariable注解的请求参数以及普通请求参数的方法
        Map map =(Map)httpServletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        System.out.println("MyInterceptor:preHandle:name:"+map.get("name"));
        System.out.println("MyInterceptor:preHandle:username:"+httpServletRequest.getParameter("username"));
        if(map.get("name").equals("zhangsan")) {
            return true;    //如果false，停止流程，api被拦截
        }else {
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.write("please login again!");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor:postHandle被调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {

        System.out.println("MyInterceptor:afterCompletion被调用");

        if(handler instanceof HandlerMethod) {
            HandlerMethod h = (HandlerMethod) handler;
            Long startTime = (Long) httpServletRequest.getAttribute("startTime");
            Long endTime = System.currentTimeMillis();

            System.out.println( new StringBuilder()
                    .append("接口响应时间过长:")
                    .append (endTime - startTime)
                    .append("ms;")
                    .append(h.getBean().getClass().getName())
                    .append(";method:")
                    .append(h.getMethod().getName()).toString()
            );

        if ((endTime - startTime) > 200) {
            logger.info(
                    new StringBuilder()
                            .append("接口响应时间过长:")
                            .append (endTime - startTime)
                            .append("ms;")
                            .append(h.getBean().getClass().getName())
                            .append(";method:")
                            .append(h.getMethod().getName()).toString()
            );
        }
        }
    }
}