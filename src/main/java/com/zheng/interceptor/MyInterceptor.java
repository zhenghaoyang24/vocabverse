package com.zheng.interceptor;

import com.zheng.pojo.User;
import com.zheng.service.UserService;
import com.zheng.utils.JudgeUserAgentUtil;
import com.zheng.utils.UserSessionCookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class MyInterceptor implements HandlerInterceptor {

//    @Autowired
//    private UserService userService;

    /*
    * request.getRequestDispatcher("").forward(request, response);  转发
    * response.sendRedirect("");  重定向
    * */


    //在目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String session_userid = UserSessionCookieUtil.getUserIDSession(request);  //获取session
        boolean userAgnet = JudgeUserAgentUtil.getUserAgnet(request);
        System.out.println(userAgnet);
        System.out.println("preHandle->session userid:"+session_userid);
        if (JudgeUserAgentUtil.getUserAgnet(request)){
            if (session_userid!=null) {
                //session不为空，则放行，
                System.out.println("Released 1");
                return true;
            }else {   //session不存在则判断cookie是否存在
                User userByNameAndEmail = UserSessionCookieUtil.getUserByCookie(request);
//                System.out.println(userByNameAndEmail);
                if (userByNameAndEmail==null){   //cookie不存在，则拦截，并重定向到登录页面
                    response.sendRedirect("registerPage");
                    System.out.println("Intercepted");
                    return false;
                }
                else {
                    UserSessionCookieUtil.setUserIDSession(String.valueOf(userByNameAndEmail.getUserid()), request);
                    System.out.println("Released 2");    //cookie存在，放行
                    return true;
                }
            }
        }else{
            response.sendRedirect("warnPage");
            return false;
        }

    }

    //在目标执行完后，视图返回对象之前执行,如没有return异常，不会执行postHandle
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }


    //目标方法完全执行完后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
        //发生异常时，会执行
    }
}
