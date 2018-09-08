package com.baizhi.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解的运行时机
@Retention(RetentionPolicy.RUNTIME)
//主机的应用位置，
@Target({ElementType.METHOD})
public @interface LogAnnotation {
    //声明属性：属性类型，属性名（）
    String name();
}
