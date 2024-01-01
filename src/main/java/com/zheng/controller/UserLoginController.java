package com.zheng.controller;

import com.zheng.pojo.User;
import com.zheng.service.UserService;
import com.zheng.utils.GetNowDataUtil;
import com.zheng.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private UserService userService;


    /**
     * 注册
     * @param user
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/userSignUp", method = RequestMethod.POST)
    @ResponseBody
    public String userSignUp(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("exe_RequestMapping_userSignUp");
        System.out.println(user);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println(user);
        Random random = new Random();
        int userid = random.nextInt(999998998) + 1001;
        while ((userService.findUserById(userid)) != null) {
            userid = random.nextInt(999998998) + 1001;
        }
        user.setUserid(userid);
        /*密码加密*/
        String userpassword = user.getUserpassword();
        userpassword = Md5Utils.md5Code(userpassword);
        user.setUserpassword(userpassword);
        /*看邮箱是否使用*/
        User userByEmail = userService.findUserByEmail(user.getUseremail());
        System.out.println("awdawd："+userByEmail);
        System.out.println(user);
        if (userByEmail != null) {
            System.out.println("userByEmail already exist");
            return "emailexit";
        } else {
            System.out.println("signup success");
            String nowData = GetNowDataUtil.getNowData();
            user.setRegtime(nowData);
            System.out.println(user);
            userService.userSignUp(user);
            return "success";
        }

    }

    /**
     * 登录
     * @param user
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/userSignIn", method = RequestMethod.POST)
    @ResponseBody
    public String userSignIn(User user, boolean checkboxIsChecked, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println("-----------------------------");
        System.out.println("exe_RequestMapping_userSignIn");
//        System.out.println(checkboxIsChecked);
//        String[] checkboxIsChecked = request.getParameterValues("checkboxIsChecked");
//        System.out.println(Arrays.toString(checkboxIsChecked));

        /*获取请求体数据*/
//        BufferedReader reader = request.getReader();
//        String s = reader.readLine();
        //        user = JSON.parseObject(s, User.class);
        /*将JSON转为java对象*/
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        User userByEmail = userService.findUserByEmail(user.getUseremail());
        if (userByEmail == null) {   //用户不存在
            System.out.println("no user.");
            return "nouser";
        } else {  //用户存在
            String userpassword = user.getUserpassword(); //获取用户输入的密码
            userpassword  = Md5Utils.md5Code(userpassword);
//            user.setUserpassword(userpassword);
//            user.setUserid(userByEmail.getUserid());
            System.out.println("userSignIn:"+user);
            if (!Objects.equals(userpassword, userByEmail.getUserpassword())) {
                System.out.println("password error");
                return  "passworderror";
            }else {
                System.out.println("password right");
                /*session*/
                session.setAttribute("userid", userByEmail.getUserid());//保存当前登录用户Id
                if (checkboxIsChecked)  //是否勾选记住我，设置cookie
                {
                    Cookie useremail = new Cookie("useremail", userByEmail.getUseremail());
                    Cookie userpassword1 = new Cookie("userpassword", userByEmail.getUserpassword());
                    useremail.setMaxAge(3600*24*3);
                    useremail.setPath("/");  //同域名全部路径均可使用该Cookie
                    userpassword1.setMaxAge(3600*24*3);
                    userpassword1.setPath("/");  //同域名全部路径均可使用该Cookie
                    /*发送cookie*/
                    response.addCookie(useremail);
                    response.addCookie(userpassword1);
                }
                return  "succession";
            }
        }


    }


}
