package com.zheng.controller;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.zheng.pojo.User;
import com.zheng.service.UserService;
import com.zheng.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.Random;

@Controller
@RequestMapping("/register")
public class UserLoginController {

    @Autowired
    private UserService userService;


//    @RequestMapping(value = "/getCode",method = RequestMethod.GET)
//    @ResponseBody
//    public String getCode(HttpSession httpSession, String username, String email, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String Captcha = String.valueOf(new Random().nextInt(899999) + 100000);
////        Md5Utils md5Utils = new Md5Utils();
////        //生成六位数验证码
//        System.out.println("mySendMail");
//
//
//        try {
//            // 发送普通文本邮件
//            mailUtil.sendMail("zhenghaoyang24@foxmail.com", "验证码", Captcha);
//            // 发送带附件的邮件
//        } catch (AddressException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        return Captcha;
//
//    }

    //新注册
//    @RequestMapping(value = "/userSignUp", method = RequestMethod.POST)
//    @ResponseBody
//    public String userRegister(String useremail, String userpassword, String code) {
//        System.out.println("userRegister");
//        System.out.println(useremail);
//        System.out.println(userpassword);
//        System.out.println("code=" + code);
//        User userByEmail = userService.findUserByEmail(useremail);
//        if (userByEmail == null) {   //用户不存在
//            System.out.println("no user.");
//            return "nouser";
//        } else {  //用户存在，判断密码是否正确
//            String userpasswordMd5eD = Md5Utils.md5Code(userpassword);  //将用户密码加密
//            if (!Objects.equals(userpasswordMd5eD, userByEmail.getUserpassword())) {  //密码错误
//                System.out.println("password error");
//                return "passworderror";
//            }
//
//
//        }
//
//
//        return "test";
//
//    }


    //发送验证码
//    @RequestMapping("/send")
//    @ResponseBody
//    public String sendEmail(HttpSession httpSession, String username, String email, HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // 获取用户的邮箱
//        // 实例化用户对象
//        User user = null;
//        // 实例化一个发送邮件的对象
//        SendMail mySendMail = new SendMail();
//        //生成六位数验证码
//        String Captcha = String.valueOf(new Random().nextInt(899999) + 100000);
//        //存储验证码
//        httpSession.setAttribute("Captcha", Captcha);
//        SimpleMailMessage message = new SimpleMailMessage();
//        //邮件主题
//        message.setSubject("验证码");
//        //邮件内容
//        message.setText("验证码:" + Captcha);
//        mySendMail.sendMail(email, "您的验证码为：" + Captcha);
//        return Captcha;
//    }


    /**
     * 注册
     *
     * @param user
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/userSignUp", method = RequestMethod.POST)
    @ResponseBody
    public String userSignUp(User user, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
        System.out.println("awdawd：" + userByEmail);
//        System.out.println(user);
        if (userByEmail != null) {
            System.out.println("userByEmail already exist");
            return "emailexit";
        } else {  //注册成功，
            System.out.println("signup success");
            String nowData = GetNowDataUtil.getNowData();
            user.setRegtime(nowData);
//            System.out.println(user);
            userService.userSignUp(user);
            //设置cookie
            UserSessionCookieUtil.setUserCookie(user.getUseremail(), user.getUserpassword(), response);
            //设置session
            UserSessionCookieUtil.setUserIDSession(String.valueOf(user.getUserid()), request);
            //重定向
            return "success";
        }

    }

    /**
     * 登录
     *
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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        User userByEmail = userService.findUserByEmail(user.getUseremail());
        if (userByEmail == null) {   //用户不存在
            System.out.println("no user.");
            return "nouser";
        } else {  //用户存在
            String userpassword = user.getUserpassword(); //获取用户输入的密码
            userpassword = Md5Utils.md5Code(userpassword);
//            user.setUserpassword(userpassword);
//            user.setUserid(userByEmail.getUserid());
            System.out.println("userSignIn:" + user);
            if (!Objects.equals(userpassword, userByEmail.getUserpassword())) {
                System.out.println("password error");
                return "passworderror";
            } else {
                System.out.println("password right");
                /*session*/
                UserSessionCookieUtil.setUserIDSession(String.valueOf(userByEmail.getUserid()),request);
//                session.setAttribute("userid", userByEmail.getUserid());//保存当前登录用户Id
                if (checkboxIsChecked)  //是否勾选记住我，设置cookie
                {
                    UserSessionCookieUtil.setUserCookie(userByEmail.getUseremail(),userByEmail.getUserpassword(),response);
//                    Cookie useremail = new Cookie("useremail", userByEmail.getUseremail());
//                    Cookie userpassword1 = new Cookie("userpassword", userByEmail.getUserpassword());
//                    useremail.setMaxAge(3600 * 24 * 3);
//                    useremail.setPath("/");  //同域名全部路径均可使用该Cookie
//                    userpassword1.setMaxAge(3600 * 24 * 3);
//                    userpassword1.setPath("/");  //同域名全部路径均可使用该Cookie
//                    /*发送cookie*/
//                    response.addCookie(useremail);
//                    response.addCookie(userpassword1);
                }
                return "succession";
            }
        }


    }




}
