package com.zheng.controller;

import com.zheng.pojo.*;
import com.zheng.service.*;
import com.zheng.utils.GetDateUtil;
import com.zheng.utils.SMCountUtil;
import com.zheng.utils.UserSessionCookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    @Autowired
    private StudyWordService studyWordService;

    @RequestMapping(value = "/feedbackStudyWord", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public boolean feedBackStudyWord(int wordid,int quality,int dayStudyCount,int difficulty,int totalStudyTime,HttpServletRequest request) {
        String nowData = GetDateUtil.getNowData();
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request)) ;
        StudyWord studyWord = studyWordService.getStudyWordInformation(wordid, userid);
        Daily daily = dailyService.getDaily(userid, nowData);  //获取daily
        if (dayStudyCount == 0) {
            // 每天第一次记  初始化day_q  studyCount+1  添加记忆历史
            studyWord.setDay_q_0(0);
            studyWord.setDay_q_1(0);
            studyWord.setDay_q_2(0);
            studyWord.setDay_studycount(0);
            studyWord.setLaststudydate(nowData);
            studyWord.setStudycount(studyWord.getStudycount()+1);
            //添加记忆历史
            if (studyWordService.getStudyWordRememberHistoryById(userid,wordid,nowData)==null){
                StudyWordRememberHistory wordRememberHistory = new StudyWordRememberHistory();
                wordRememberHistory.setUserid(userid);
                wordRememberHistory.setWordid(wordid);
                wordRememberHistory.setOpt(quality);
                wordRememberHistory.setSelectdate(nowData);
                studyWordService.addStudyWordRememberHistory(wordRememberHistory);
            }
            //机算曲线（待做）
        }
        //机算EF
        studyWord.setEf(SMCountUtil.getNewEF(studyWord.getEf(), quality));
        //计算天数
        if (quality==0){
            studyWord.setQ_0(studyWord.getQ_0()+1);
            studyWord.setDay_q_0(studyWord.getDay_q_0()+1);
        }
        if (quality==1){
            studyWord.setQ_1(studyWord.getQ_1()+1);
            studyWord.setDay_q_1(studyWord.getDay_q_1()+1);
        }
        if (quality==2){
            studyWord.setQ_2(studyWord.getQ_2()+1);
            studyWord.setDay_q_2(studyWord.getDay_q_2()+1);
        }
        if (quality==3){
            studyWord.setQ_3(studyWord.getQ_3()+1);
            //计算间隔天数
            double weight = SMCountUtil.countDayWeight(studyWord.getDay_q_0(), studyWord.getDay_q_1(), studyWord.getDay_q_2(), dayStudyCount + 1);
            int day = SMCountUtil.nextDay(studyWord.getQ_0() + studyWord.getQ_1() + studyWord.getQ_2() + studyWord.getQ_3(), studyWord.getEf(), quality, difficulty, weight);
            //计算下一个复习日期
            System.out.println("day="+day);
            studyWord.setIntervalday(day);
            String nextDate = GetDateUtil.getNextDate(day);
            studyWord.setNextstudydate(nextDate);
            daily.setStudyword(daily.getStudyword()+1);  //daily 学习单词+1
        }
        daily.setStudytime(daily.getStudytime()+1);  //daily学习次数+1
        daily.setStudyduration(daily.getStudyduration()+totalStudyTime);
        //学习时间
        dailyService.updateDailyFeedbackDate(daily);

        studyWord.setDay_studycount(studyWord.getDay_studycount()+1);
        //更改值
        return studyWordService.updateStudyWordInformation(studyWord);
    }


    @RequestMapping(value = "/deleteTheStudyWord", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteTheStudyWord(int wordid,HttpServletRequest request) throws ParseException {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        StudyWord studyWord = studyWordService.getStudyWordInformation(wordid, userid);
        String nowDateString =null;
        nowDateString = GetDateUtil.getNowData();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date nextstudydate = sdf.parse(studyWord.getNextstudydate());
        Date nowData = sdf.parse(nowDateString);
        boolean b = studyWordService.deleteTheStudyWord(userid, wordid);

        if (b){
            wordService.updateWordStudyTime(wordid, "sub");  //更改studytime
            Daily d = dailyService.getDaily(userid, nowDateString);
            if (d != null){
                if (nextstudydate.compareTo(nowData) <= 0) { //删除的单词在日期之前
                    dailyService.setShouldStudy(d.getShouldstudy()-1, userid, nowDateString);
                }
            }
        }
        return b;
    }


    /*添加学习计划单词 添加一个*/
    @RequestMapping(value = "/addStudyWord", method = RequestMethod.POST)
    @ResponseBody
    public boolean addStudyWord(int wordid,HttpServletRequest request){
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));

        String nowData = GetDateUtil.getNowData();
        boolean b = studyWordService.addStudyWordService(userid, wordid, nowData, nowData);
        if (b){
            wordService.updateWordStudyTime(wordid, "add");  //更改studytime
            Daily d = dailyService.getDaily(userid, nowData);
            if (d != null){
                dailyService.setShouldStudy(d.getShouldstudy()+1, userid, nowData);
            }
        }

        return b;
    }



//    @RequestMapping(value = "/creatDaily", method = RequestMethod.POST)
//    @ResponseBody
//    public void creatDaily(HttpServletRequest request) {
//        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
//        String time = GetDateUtil.getNowData();
//        Daily daily = new Daily();
//        daily.setUserid(userid);
//        daily.setTime(time);
//        daily.setCheckin(0);
//        daily.setSearchedword(0);
//        daily.setStudytime(0);
//        daily.setStudyword(0);
//        daily.setStudyduration(0);
//        daily.setShouldstudy(studyWordService.getTodayStudyWordsCount(userid, time));
//        dailyService.creatDaily(daily);
//    }

    @RequestMapping(value = "/addSearchedWordCount", method = RequestMethod.POST)
    @ResponseBody
    public void addSearchedWordCount(HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        String time = GetDateUtil.getNowData();
        dailyService.addSearchedWordCount(userid, time);
    }

    @RequestMapping(value = "/setStudyWordState", method = RequestMethod.POST)
    @ResponseBody
    public boolean setStudyWordState(int state,int wordid,HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        boolean b = studyWordService.setStudyWordState(state, userid, wordid);
        return b;
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
            String nowData = GetDateUtil.getNowData();
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
        String nowData = GetDateUtil.getNowData();
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


    /*修改用户基本信息*/
    @RequestMapping(value = "/updateUserData", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateUserData(String newValue, String category,HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        return userService.updateUserDataService(newValue, category, userid);
    }

    /*修改密码*/






}
