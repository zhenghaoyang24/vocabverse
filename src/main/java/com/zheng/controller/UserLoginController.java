package com.zheng.controller;

import com.zheng.pojo.User;
import com.zheng.service.UserService;
import com.zheng.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    @RequestMapping("/getCode")
    @ResponseBody
    public String sendEmail(HttpSession httpSession, String username, String email) {
        //生成六位数验证码
        String emailCode = String.valueOf(new Random().nextInt(899999) + 100000);
        //存储验证码
        SendMailCodeUtil.sendMail(email, emailCode);
        return emailCode;
    }


    //修改密码
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String updatePassword(String oldPassword, String newPassword1, HttpServletRequest request) {
        System.out.println(oldPassword);
        System.out.println(newPassword1);

        //验证旧密码是否正确
        String s_updatePassword = Md5Utils.md5Code(oldPassword);
        System.out.println(s_updatePassword);
        User user = userService.findUserById(Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request)));
        System.out.println(user.getUserpassword());
        if (user.getUserpassword().equals(s_updatePassword)) {  //旧密码正确  看新旧密码是否一样
            System.out.println("test");
            if (oldPassword.equals(newPassword1)) {
                return "旧密码不能与新密码一样";
            } else {  //允许更改
                boolean b = userService.updatePasswordService(Md5Utils.md5Code(newPassword1), Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request)));
                if (b) {
                    return "密码更改成功";
                } else {
                    return "发送未知错误，密码更改失败";
                }
            }
        } else {
            return "旧密码不正确";
        }

    }

    //忘记密码页面
    //重置密码
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String resetPassword(String newPassword1,String email, HttpServletRequest request) {
        User user = userService.findUserByEmail(email);
        if (user == null) {
            return "该邮箱还没有注册";
        }else{
            boolean b = userService.updatePasswordService(Md5Utils.md5Code(newPassword1), user.getUserid());
            if (b) {
                return "密码更改成功,请登录";
            } else {
                return "发送未知错误，密码更改失败";
            }
        }



    }

    /*退出登录*/
    @RequestMapping("/loginOut")
    @ResponseBody
    public boolean loginOut(HttpServletRequest request, HttpServletResponse response) {
        UserSessionCookieUtil.removeUserCookieAndSession(request, response);  //删除cookie与session
        String session = UserSessionCookieUtil.getUserIDSession(request);
        UserSessionCookieUtil.getUserByCookie(request);
        System.out.println("userid=" + session);
        return true;
    }

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
            user.setLevel(0);
            user.setGender(2);  //2为外星人
            user.setAvatar("image/avatar/avatar_default.png");
            userService.userSignUp(user);

            if (UserSessionCookieUtil.getUserByCookie(request) != null) {  //若存在cookie这先删除
                UserSessionCookieUtil.removeUserCookieAndSession(request, response);
                UserSessionCookieUtil.setUserCookie(user.getUseremail(), user.getUserpassword(), response);//设置cookie
            } else {
                UserSessionCookieUtil.setUserCookie(user.getUseremail(), user.getUserpassword(), response);
            }

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
    public String userSignIn(User user, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
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
                UserSessionCookieUtil.setUserIDSession(String.valueOf(userByEmail.getUserid()), request);

                if (UserSessionCookieUtil.getUserByCookie(request) != null) {  //若存在cookie这先删除
                    UserSessionCookieUtil.removeUserCookieAndSession(request, response);
                    UserSessionCookieUtil.setUserCookie(userByEmail.getUseremail(), userByEmail.getUserpassword(), response);//设置cookie
                } else {
                    UserSessionCookieUtil.setUserCookie(userByEmail.getUseremail(), userByEmail.getUserpassword(), response);
                }
                return "succession";
            }
        }


    }


}
