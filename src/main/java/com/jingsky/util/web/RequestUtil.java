package com.jingsky.util.web;

import com.jingsky.util.lang.StringUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * request相关工具类
 */
public class RequestUtil {

    /**
     * 获取当前请求的全路径，包含参数信息。
     * @param request
     * @return String
     */
    public static String getRequestFullUrl(HttpServletRequest request) {
        String serverName = request.getServerName();
        String referUrl = request.getScheme() + "://" + serverName + ":" + request.getServerPort() + request.getContextPath() + "/" + (StringUtil.isEmpty(request.getQueryString()) ? "" : "?" + request.getQueryString());
        return referUrl;
    }

    /**
     * 获取真实ip地址
     * @param request
     * @return
     */
    public static String getRemoteAddrIp(HttpServletRequest request) {
        String value = request.getHeader("X-Real-IP");
        String ipFromNginx= !StringUtil.isEmpty(value) && !"unknown".equalsIgnoreCase(value) ? value : "";
        return StringUtil.isEmpty(ipFromNginx) ? request.getRemoteAddr() : ipFromNginx;
    }


}
