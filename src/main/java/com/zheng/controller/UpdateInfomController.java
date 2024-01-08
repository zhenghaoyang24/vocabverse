package com.zheng.controller;

import com.zheng.pojo.Example;
import com.zheng.service.ExampleService;
import com.zheng.service.WordService;
import com.zheng.utils.GetNowDataUtil;
import com.zheng.utils.UserSessionCookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/update")
public class UpdateInfomController {

    @Autowired
    WordService wordService;
    @Autowired
    ExampleService exampleService;


    /**
     * 为例句添加热度
     *
     * @param heat
     * @param exapid
     * @return
     */
    @RequestMapping("/addHeat")
    @ResponseBody
    public boolean addHeat(int heat, int exapid) {
        System.out.println(heat + "=" + exapid);
        boolean b = exampleService.addHeat(heat, exapid);
        return b;
    }

    /**
     * 为单词添加例句
     *
     * @param example
     * @return
     */
    @RequestMapping(value = "/addExample", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addExample(Example example, HttpServletRequest request) {
        System.out.println(example);
        if (example.getEn().length() == 0)
            return "noen";
        if (example.getCn().length() == 0)
            return "nocn";
        String word = wordService.findWordById(example.getWordid()).getSpelling();
        //判断英文例句是否有这个单词
        if (example.getEn().contains(word)) {
            int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
            String nowData = GetNowDataUtil.getNowData();
            example.setAdddate(nowData);
            example.setHolderid(userid);
            System.out.println(example);
            boolean b = exampleService.addExample(example);
            String b_ = String.valueOf(b);
            System.out.println("b_=" + b_);
            return b_;
        } else
            return "noword";
    }

    /**
     * 删除例句
     */
    @RequestMapping(value = "/deleteExample", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteExample(int exapid) {
        boolean b = exampleService.deleteExample(exapid);
        return b;
    }

    /**
     * 编辑例句
     * @param example
     * @return
     */
    @RequestMapping(value = "/editExample", method = RequestMethod.POST)
    @ResponseBody
    public String editExample(Example example) {
        System.out.println(example);
        if (example.getEn().length() == 0)
            return "noen";
        if (example.getCn().length() == 0)
            return "nocn";
        String word = wordService.findWordById(example.getWordid()).getSpelling();
        //判断英文例句是否有这个单词
        if (example.getEn().contains(word)) {
            System.out.println(example);
            boolean b = exampleService.editExample(example);
            String b_ = String.valueOf(b);
            System.out.println("b_=" + b_);
            return b_;
        } else
            return "noword";
    }

}
