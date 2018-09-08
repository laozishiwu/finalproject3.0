package com.baizhi.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextUtil {
    private static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<>();

    public static ThreadLocal<HttpServletRequest> getRequestThreadLocal() {
        return requestThreadLocal;
    }

    public static void setRequestThreadLocal(ThreadLocal<HttpServletRequest> requestThreadLocal) {
        ContextUtil.requestThreadLocal = requestThreadLocal;
    }

    public static ThreadLocal<HttpServletResponse> getResponseThreadLocal() {
        return responseThreadLocal;
    }

    public static void setResponseThreadLocal(ThreadLocal<HttpServletResponse> responseThreadLocal) {
        ContextUtil.responseThreadLocal = responseThreadLocal;
    }

    public static void deleteRequest() {
        requestThreadLocal.remove();
    }

    public static void deleteResponse() {
        responseThreadLocal.remove();
    }
}
