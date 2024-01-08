package com.zheng.controller;

import com.zheng.pojo.User;
import com.zheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class ToPageController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String toSystem() {
        return "login";
    }


    @RequestMapping("/loginPage")
    public String toLoginPage() {
        return "login";
    }

    @RequestMapping("/registerPage")
    public String toRegisterPage() {
        return "page_register";
    }



    @RequestMapping("/homePage")
    public String toIndex00(HttpServletRequest request) {
//        setUserIDSessionUtil(request);
        return "index_00";
    }

    @RequestMapping("/studyPage")
    public String To_index01(HttpServletRequest request) {
//        setUserIDSessionUtil(request);
        return "index_01";
    }

    @RequestMapping("/searchPage")
    public String To_index02(HttpServletRequest request) {
//        setUserIDSessionUtil(request);
        return "index_02";
    }

    @RequestMapping( "/wordDetailPage")
    public String searchWordDetail(int wordid,HttpServletRequest request) {
        request.getSession().setAttribute("wordid", wordid);
        return "page_WordDetail";
    }


    @RequestMapping("/translatePage")
    public String To_index03(HttpServletRequest request) {
//        setUserIDSessionUtil(request);
        return "index_03";
    }

    @RequestMapping("/dataPage")
    public String To_index04(HttpServletRequest request) {
//        setUserIDSessionUtil(request);
        return "index_04";
    }



//    public void setUserIDSessionUtil(HttpServletRequest request){
//        HttpSession session = request.getSession();
//        if (session.getAttribute("userid")==null){
//            String useremail=null,userpassword = null;
//            Cookie[] cookies = request.getCookies();
//            User userByNameAndEmail;
//            for (int i = 0; i < cookies.length; i++) {
//                if (Objects.equals(cookies[i].getName(), "useremail"))
//                    useremail= cookies[i].getValue();
//                if (Objects.equals(cookies[i].getName(), "userpassword"))
//                    userpassword= cookies[i].getValue();
//            }
//            System.out.println("preHandle->useremail:"+useremail);
//            System.out.println("preHandle->userpassword:"+userpassword);
//            userByNameAndEmail = userService.findUserByNameAndEmail(useremail, userpassword);
//            session.setAttribute("userid", userByNameAndEmail.getUserid());//保存当前登录用户Id
//            Object userid = request.getSession().getAttribute("userid");
//            System.out.println("setUserIDSessionUtil->userid:"+userid);
//        }
//    }
}




