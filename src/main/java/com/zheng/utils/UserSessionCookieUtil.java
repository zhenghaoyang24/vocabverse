package com.zheng.utils;

import com.zheng.pojo.User;
import com.zheng.service.UserService;
import com.zheng.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class UserSessionCookieUtil {

    @Autowired
    UserService userService;


    public static void setUserIDSession(String userid, HttpServletRequest request) {
        request.getSession().setAttribute("userid", userid);
//        System.out.println("setUserIDSession userid = " +request.getSession().getAttribute("userid"));
    }


    public static String getUserIDSession(HttpServletRequest request) {
//        System.out.println((String) request.getSession().getAttribute("userid"));
        return (String) request.getSession().getAttribute("userid");
    }

    public static void setUserCookie(String useremail, String userpassword, HttpServletResponse response) {
        Cookie coo_kieuseremail = new Cookie("useremail", useremail);
        Cookie cookie_userpassword1 = new Cookie("userpassword", userpassword);
        coo_kieuseremail.setMaxAge(3600 * 24 * 3);
        coo_kieuseremail.setPath("/");  //同域名全部路径均可使用该Cookie
        cookie_userpassword1.setMaxAge(3600 * 24 * 3);
        cookie_userpassword1.setPath("/");  //同域名全部路径均可使用该Cookie

        /*发送cookie*/
        response.addCookie(coo_kieuseremail);
        response.addCookie(cookie_userpassword1);
    }

    public static User getUserByCookie(HttpServletRequest request) {
        String useremail = null, userpassword = null;
        Cookie[] cookies = request.getCookies();
        UserService userService = new UserServiceImpl();
        User user;
        for (int i = 0; i < cookies.length; i++) {
            if (Objects.equals(cookies[i].getName(), "useremail"))
                useremail = cookies[i].getValue();
            if (Objects.equals(cookies[i].getName(), "userpassword"))
                userpassword = cookies[i].getValue();
        }
//        System.out.println(userService.findUserByNameAndEmail(useremail, userpassword));
        return userService.findUserByNameAndEmail(useremail, userpassword);

    }

    public static void removeUserCookieAndSession(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("userid");  //删除session
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            System.out.println("no cookie");
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("useremail")) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
                if (cookie.getName().equals("userpassword")) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
    }


}
