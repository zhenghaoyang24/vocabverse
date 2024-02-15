package com.zheng.utils;

import javax.servlet.http.HttpServletRequest;

public class JudgeUserAgentUtil {

    public  static boolean getUserAgnet(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("Windows")) {
            return true;
        }else{
            return false;
        }

    }

}
