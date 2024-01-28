package com.zheng.controller;

import com.alibaba.fastjson.JSONObject;
import com.zheng.pojo.*;
import com.zheng.service.*;
import com.zheng.utils.GetNowDataUtil;
import com.zheng.utils.UserSessionCookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/update")
public class UpdateInfomController {

    @Autowired
    private WordService wordService;
    @Autowired
    private ExampleService exampleService;
    @Autowired
    private UserBookService userBookService;
    @Autowired
    private DailyService dailyService;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/creatDaily", method = RequestMethod.POST)
    @ResponseBody
    public void creatDaily(HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        String time = GetNowDataUtil.getNowData();
        Daily daily = new Daily();
        daily.setUserid(userid);
        daily.setTime(time);
        daily.setCheckin(0);
        daily.setSearchedword(0);
        daily.setStudytime(0);
        daily.setStudyword(0);
        System.out.println(daily);
        dailyService.creatDaily(daily);
    }

    @RequestMapping(value = "/addSearchedWordCount", method = RequestMethod.POST)
    @ResponseBody
    public void addSearchedWordCount(HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        String time = GetNowDataUtil.getNowData();
        dailyService.addSearchedWordCount(userid, time);
    }

    @RequestMapping(value = "/deleteSearchWordHistory", method = RequestMethod.POST)
    @ResponseBody
    public void deleteSearchWordHistory(int wordid,HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        wordService.deleteSearchWordHistory(wordid, userid);
    }

    @RequestMapping(value = "/deleteAllSearchWordHistory", method = RequestMethod.POST)
    @ResponseBody
    public void deleteAllSearchWordHistory(HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        wordService.deleteAllSearchWordHistory(userid);
    }


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
        System.out.println("addHeat");
        boolean b = exampleService.addHeat(heat, exapid);
        return b;
    }


    /**
     * 增加搜索次数
     *
     * @param wordid
     * @return
     */
    @RequestMapping("/addSearchTimes")
    @ResponseBody
    public boolean addSearchTimes(int wordid) {
        boolean b = wordService.addSearchTimes(wordid);
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
        System.out.println("addExample");
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
     *
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


    /**
     * 添加自定义书籍
     *
     * @param userBook
     * @param request
     * @return
     */
    @RequestMapping(value = "/addUserBook", method = RequestMethod.POST)
    @ResponseBody
    public String addUserBook(UserBook userBook, HttpServletRequest request) {
        if (userBook.getUserbookname().length() == 0) {
            return "NoUserBookName";
        }
        String nowData = GetNowDataUtil.getNowData();
        userBook.setVoccount(0);
        userBook.setCreattime(nowData);
//        System.out.println(userBook);
        boolean b = userBookService.addUserBookMapper(userBook);
        return String.valueOf(b);
    }


    /**
     * 添加单词到自定义词库
     *
     * @param wordid
     * @param userbookid
     * @return
     */
    @RequestMapping(value = "/addWordToUserBook", method = RequestMethod.POST)
    @ResponseBody
    public boolean addWordToUserBook(int wordid, int userbookid) {
        System.out.println("addWordToUserBook");
        return userBookService.addWordToUserBook(wordid, userbookid);
    }

    @RequestMapping(value = "/deleteWordFromUserBookMapper", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteWordFromUserBookMapper(int wordid, int bookid) {
        System.out.println("deleteWordFromUserBookMapper");
        return userBookService.deleteWordFromUserBookMapper(wordid, bookid);
    }

    @RequestMapping(value = "/addSearchedWordHistory", method = RequestMethod.POST)
    @ResponseBody
    public boolean setSearchHistoryCookie(int wordid, String spelling,HttpServletRequest request) {
        String userid = UserSessionCookieUtil.getUserIDSession(request);
        SearchWordHistory searchWordHistory = new SearchWordHistory();
        searchWordHistory.setSpelling(spelling);
        searchWordHistory.setUserid(Integer.parseInt(userid));
        searchWordHistory.setWordid(wordid);
        return wordService.addSearchedWordHistory(searchWordHistory);
    }


    @RequestMapping(value = "/updateUserData", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateUserData(String newValue, String category,HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        return userService.updateUserDataService(newValue, category, userid);
    }





}
