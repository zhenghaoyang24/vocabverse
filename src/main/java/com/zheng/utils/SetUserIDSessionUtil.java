package com.zheng.utils;

import com.zheng.pojo.User;
import com.zheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class SetUserIDSessionUtil {



    public static void setUserIDSessionUtil(HttpServletRequest request){
        UserService userService = null;
        System.out.println("1");
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
        System.out.println("2");
        System.out.println("preHandle->useremail:"+useremail);
        System.out.println("preHandle->userpassword:"+userpassword);
        userByNameAndEmail = userService.findUserByNameAndEmail(useremail, userpassword);
        System.out.println("3");
        HttpSession session = request.getSession();
        System.out.println("4");
        session.setAttribute("userid", userByNameAndEmail.getUserid());//保存当前登录用户Id
        Object userid = request.getSession().getAttribute("userid");
        System.out.println("setUserIDSessionUtil->userid:"+userid);

    }


}
