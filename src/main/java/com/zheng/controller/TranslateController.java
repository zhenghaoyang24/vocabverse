package com.zheng.controller;

import com.zheng.utils.HttpURLConnectionUtil;
import com.zheng.utils.Md5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("translate")
public class TranslateController {

    @RequestMapping(value = "translateText",method = RequestMethod.GET)
    @ResponseBody
    public String translate(String inputText,String toLanguageEn) {
        System.out.println(inputText);
        String appId = "XXX";  //appid
        String userCode = "XXX";  //秘钥
        String  befor_sign = appId + inputText + "1435660288"+userCode;
        String sign = Md5Utils.md5Code(befor_sign);
        String httpUrl = "http://api.fanyi.baidu.com/api/trans/vip/translate?q="+inputText+"&from=auto&to="+toLanguageEn+"&appid="+appId+"&salt=1435660288&sign="+sign;
        String outText = HttpURLConnectionUtil.doGet(httpUrl);
        System.out.println(outText);
        return outText;

    }
}
