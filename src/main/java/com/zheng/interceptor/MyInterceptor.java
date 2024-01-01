package com.zheng.interceptor;

import com.zheng.pojo.User;
import com.zheng.service.UserService;
import com.zheng.utils.SetUserIDSessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    /*
    * request.getRequestDispatcher("").forward(request, response);  转发
    * response.sendRedirect("");  重定向
    * */


    //在目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");
        Object userid = request.getSession().getAttribute("userid");
        System.out.println("preHandle->userid:"+userid);
        if ((request.getSession().getAttribute("userid"))!=null) {
            //session不为空，则放行，
            System.out.println("Released");
            return true;
        }else {   //session不存在则判断cookie是否存在
            String useremail = null;
            String userpassword = null;
            Cookie[] cookies = request.getCookies();
            User userByNameAndEmail;
            for (int i = 0; i < cookies.length; i++) {
                if (Objects.equals(cookies[i].getName(), "useremail"))
                    useremail= cookies[i].getValue();
                if (Objects.equals(cookies[i].getName(), "userpassword"))
                    userpassword= cookies[i].getValue();
            }
            System.out.println("preHandle->useremail:"+useremail);
            System.out.println("preHandle->userpassword:"+userpassword);
            userByNameAndEmail = userService.findUserByNameAndEmail(useremail, userpassword);
            if (userByNameAndEmail==null){   //cookie不存在，则拦截，并重定向到登录页面
                response.sendRedirect("loginPage");
                System.out.println("Intercepted");
                return false;
            }
            else {
//                SetUserIDSessionUtil.setUserIDSessionUtil(userByNameAndEmail,request);
                System.out.println("Released");    //cookie存在，放行
                return true;
            }
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
