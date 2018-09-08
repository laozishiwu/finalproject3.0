package com.baizhi.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;


@Aspect//定义切面（切入点，通知）
@Configuration//把对象交给工厂管理
public class MyLogAspect {
    //切入点
    @Pointcut(value = "@annotation(LogAnnotation)")
    public void pointCut() {
    }

    //通知：引入切入点
    //@Around(value = "execution(* com.baizhi.ServiceImp.*.delete(..))||execution(* com.baizhi.ServiceImp.*.insert(..))||execution(* com.baizhi.ServiceImp.*.update(..))")
    @Around("pointCut()")
    //通过形参的注入获取方法对象，连接点对象ProceedingJoinPoint
    public void logAspect(ProceedingJoinPoint pjp) {
        //做日志什么人，什么时间，做了什么事儿，事情执行结果，登录后用户信息存储在session，
        //普通方法里获取session对象，需要强转
        ServletRequestAttributes servletRequestAtibutes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取session
        HttpSession session = servletRequestAtibutes.getRequest().getSession();
        //什么人
        Object user = session.getAttribute("user");
        //什么时间
        Date date = new Date();
        //行为
        //借助getSignature()工具获取目标方法，（需要强转为MethodSignature）
        MethodSignature pjpSignature = (MethodSignature) pjp.getSignature();
        //获取去目标方法
        Method method = pjpSignature.getMethod();
        //基于ciglib在实现类上加完注解后，获取目标方法的名字，注解，参数...(自定义注解)
        //再添加注解的方法上添加额外功能
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        //获取注解名字
        String name = annotation.name();
        //查看事情的执行结果，借助标志位判断目标方法是否执行成功
        Boolean flag = false;//设置为false
        //监控目标方法的执行，返回值代表目标方法
        try {
            //监控目标方法的执行,返回值代表目标方法
            Object proceed = pjp.proceed();
            flag = true;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(flag);
    }

}
