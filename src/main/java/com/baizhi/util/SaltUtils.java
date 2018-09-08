package com.baizhi.util;

import java.util.Random;

//生成随机盐
public class SaltUtils {
    //生成随机盐：@Param x @return
    public static String getSalt(int n) {
        char[] code = "1234567890zxcvbnmasdfghjklqwertyuiopZXCVBNMASDFGHJKLQWERTYUIOP!@#$%^&*()-".toCharArray();
        //随机数
        Random random = new Random();
        //Stringbuilder线程不安全，效率高，轻量级
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(code[random.nextInt(code.length)]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String salt = getSalt(7);
        System.out.println(salt);
    }
}