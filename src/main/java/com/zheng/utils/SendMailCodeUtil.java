package com.zheng.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

//@Component
public class SendMailCodeUtil {


    /**
     * 外网邮件发送
     *
     * @param to
     * @param code
     */
    public static void  sendMail(String to, String code) {
        String myEmailAddr = "XXX@mail.com";
        // Session对象:
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.qq.com"); // 设置主机地址
        // smtp.qq.com
        props.setProperty("mail.smtp.auth", "true");// 认证
        // 2.产生一个用于邮件发送的Session对象
        Session session = Session.getInstance(props);

        // Message对象:
        Message message = new MimeMessage(session);
        // 设置发件人：
        try {
            // 4.设置消息的发送者
            Address fromAddr = new InternetAddress(myEmailAddr);
            message.setFrom(fromAddr);
            Address toAddr = new InternetAddress(to);
            message.setRecipient(MimeMessage.RecipientType.TO, toAddr);
            // 设置主题
            message.setSubject("来自VocabVerse词境的验证码");
            // 设置正文
            message.setContent(to+"你好："+"<br/>您的邮箱验证码为：" + code+"<br/>验证码有效时长2分钟。", "text/html;charset=UTF-8");
            // 准备发送
            Transport transport = session.getTransport("smtp");
            // 设置发射目标
            transport.connect("smtp.qq.com", myEmailAddr, "XXXXXXX");//授权码
            // 发送
            transport.sendMessage(message, message.getAllRecipients());
            // Transport对象:
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sendMail("2463193508@qq.com", "112456");
    }

}

