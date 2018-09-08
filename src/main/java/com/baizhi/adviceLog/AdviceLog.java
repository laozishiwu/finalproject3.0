package com.baizhi.adviceLog;

import com.baizhi.entity.Log;
import com.baizhi.entity.Manager;
import com.baizhi.service.LogService;
import com.baizhi.util.IdMakerUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class AdviceLog {
    @Autowired
    private LogService ls;

/*
    @Before("execution(* com.baizhi.hzq.service.*.*.*(..))")
    public void before1(){
        System.out.println("前置...............");
    }

    @After("execution(* com.baizhi.hzq.service.*.*(..))")
    public  void after1(){
        System.out.println("进入后置...........");
    }*/

    @Around("execution(* com.baizhi.service.*Imp.*.delete*(..)) ||execution(* com.baizhi.service.*Imp.*.update(..)) ||execution(* com.baizhi.service.*Imp.*.add(..))")
    public Object sound(ProceedingJoinPoint pjp) throws Throwable {
        StringBuilder stringBuilder = new StringBuilder();
        //普通方法里获取session对象，需要强转
        ServletRequestAttributes servletRequestAtibutes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取session
        HttpSession session = servletRequestAtibutes.getRequest().getSession();
        //什么人
        Manager manager = (Manager) session.getAttribute("manager");
        stringBuilder.append(manager.getUsername());

        stringBuilder.append("在");

        Date operationDate = new Date();
        stringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(operationDate));

        stringBuilder.append(" 执行 ");

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        //得到方法上操作类型注解
        Operation operation = method.getAnnotation(Operation.class);
        stringBuilder.append(operation.value());

        stringBuilder.append("操作 从 ");

        //得到类上对象名的注解
        Description annotation = AnnotationUtils.findAnnotation(method.getDeclaringClass(), Description.class);
        stringBuilder.append(annotation.value());

        stringBuilder.append("模块  使用");
        stringBuilder.append(pjp.getTarget().getClass().getName());
        stringBuilder.append(".");
        stringBuilder.append(method.getName());
        stringBuilder.append("(");
        Object[] args = pjp.getArgs();
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                stringBuilder.append(args[i].getClass());
                stringBuilder.append(":");
                stringBuilder.append(args[i]);
                if (i != args.length - 1) {
                    stringBuilder.append(",");
                }
            }
        } else {
            stringBuilder.append("无参");
        }
        stringBuilder.append(")");
        stringBuilder.append("方法");

        Log log = new Log();

        log.setId(Integer.valueOf(IdMakerUtil.getSnowID()));
        log.setManager(manager.getUsername());
        log.setContent(stringBuilder.toString());
        log.setOperatetime(operationDate);
        log.setOperatetype(operation.toString());


        ls.insert(log);
        Object proceed = pjp.proceed();
        return proceed;
    }

}
