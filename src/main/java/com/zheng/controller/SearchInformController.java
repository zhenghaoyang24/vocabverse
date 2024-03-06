package com.zheng.controller;

import com.zheng.pojo.*;
import com.zheng.service.*;
import com.zheng.utils.GetDateUtil;
import com.zheng.utils.UserSessionCookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchInformController {


    @Autowired
    private WordService wordService;
    @Autowired
    private UserService userService;
    @Autowired
    private ExampleService exampleService;
    @Autowired
    private UserBookService userBookService;
    @Autowired
    private DailyService dailyService;
    @Autowired
    private StudyWordService studyWordService;



    @RequestMapping(value = "/getTodayStudiedWords", method = RequestMethod.GET)
    @ResponseBody
    List<StudyWord> getTodayStudiedWords(HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        String date = GetDateUtil.getNowData();
        List<StudyWord> todayStudiedWords = studyWordService.getTodayStudiedWords(userid, date);
        return todayStudiedWords;
    }

    @RequestMapping(value = "/getTodayStudyWord", method = RequestMethod.GET)
    @ResponseBody
    StudyWord getTodayStudyWords(HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        String nowData = GetDateUtil.getNowData();
        StudyWord studyWord = studyWordService.getTodayStudyWord(userid, nowData);
        if (studyWord==null){
            return null;
        }else{
            Example example = exampleService.findExampleByExapid(studyWord.getExapid());
            if (example == null) {
                example = exampleService.findMostHeatExample(studyWord.getWordid());
                studyWordService.updateStudyWordExample(userid, studyWord.getWordid(), example.getExapid());
                studyWord = studyWordService.getTodayStudyWord(userid, nowData);
            }
            return studyWord;
        }



    }


    @RequestMapping(value = "/getStudyWordRememberHistory", method = RequestMethod.GET)
    @ResponseBody
    List<StudyWordRememberHistory> getStudyWordRememberHistory(int wordid, HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        List<StudyWordRememberHistory> history = studyWordService.getStudyWordRememberHistory(wordid, userid);
        return history;
    }

    @RequestMapping(value = "/getStudyWordInformation", method = RequestMethod.GET)
    @ResponseBody
    StudyWord getStudyWordInformation(int wordid, HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        StudyWord word = studyWordService.getStudyWordInformation(wordid, userid);
        return word;
    }


    @RequestMapping(value = "/getWordsSearchTimesRank", method = RequestMethod.GET)
    @ResponseBody
    List<Word> getWordsSearchTimes() {
        return wordService.getWordsSearchTimesRank();
    }

    @RequestMapping(value = "/getWordsStudyTimesRank", method = RequestMethod.GET)
    @ResponseBody
    List<Word> getWordsStudyTimesRank() {
        return wordService.getWordsStudyTimesRank();
    }

    @RequestMapping(value = "/getAllSearchWordHistory", method = RequestMethod.GET)
    @ResponseBody
    List<SearchWordHistory> getAllSearchWordHistory(HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        return wordService.getAllSearchWordHistory(userid);
    }

    @RequestMapping(value = "/getDaily", method = RequestMethod.GET)
    @ResponseBody
    public Daily getDaily(HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        String time = GetDateUtil.getNowData();
        Daily d = dailyService.getDaily(userid, time);
        if (d == null){
            Daily daily = new Daily();
//            Daily daily1 = new Daily();
            daily.setUserid(userid);
            daily.setTime(time);
            daily.setShouldstudy(studyWordService.getTodayStudyWordsCount(userid, time));
            dailyService.creatDaily(daily);
            return daily;
        }
        else
            return d;
    }


    /**
     * 输入框动态查询单词
     *
     * @param inputText
     * @return
     */
    @RequestMapping(value = "/searchWordByInput", method = RequestMethod.GET)
    @ResponseBody
    public List<Word> searchWordByInput(String inputText) {
        System.out.println("searchWordByInput");
        List<Word> wordList = null;
        boolean en = inputText.matches("^[a-zA-Z]*");
        boolean cn = inputText.matches("[\\u4e00-\\u9fa5]+");
        System.out.println("en:" + en);
        System.out.println("cn:" + cn);
        if (en && !cn) {   //输入的为英文
            wordList = wordService.findWordByLetterEn(inputText);
            return wordList;
        } else if (cn && !en) {   //输入的为中文
            wordList = wordService.findWordByLetterCn(inputText);
            return wordList;
        } else {
            return null;
        }
    }


    /**
     * 根据id搜搜单词
     *
     * @param wordid
     * @return
     */
    @RequestMapping(value = "/searchWordById", method = RequestMethod.GET)
    @ResponseBody
    public Word searchWordById(int wordid) {
        return wordService.findWordById(wordid);
    }

    /**
     * 根据id搜索例句
     *
     * @param wordid
     * @return
     */
    @RequestMapping(value = "/findExamplesByWordId", method = RequestMethod.GET)
    @ResponseBody
    public List<Example> findExamplesByWordId(int wordid) {
        return exampleService.findExampleByWordId(wordid);
    }


    /**
     * 当前用户userid
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getUserId", method = RequestMethod.GET)
    @ResponseBody
    int getUserId(HttpServletRequest request) {
        String idSession = UserSessionCookieUtil.getUserIDSession(request);
        return Integer.parseInt(idSession);
    }


    /**
     * 查询所有我的词库
     *
     * @param holderid
     * @return
     */
    @RequestMapping(value = "/allMyUserBooks", method = RequestMethod.GET)
    @ResponseBody
    public List<UserBook> allMyUserBooks(int holderid) {
        List<UserBook> userBooks = userBookService.allMyUserBooks(holderid);
        return userBooks;
    }


    /**
     * 判断这个单词是否在这本书里
     *
     * @param wordid
     * @param bookid
     * @return
     */
    @RequestMapping(value = "/judgeTheWordInTheBook", method = RequestMethod.GET)
    @ResponseBody
    public boolean judgeTheWordInTheBook(int wordid, int bookid) {
        VocBook vocBook = userBookService.judgeTheWordInTheBook(wordid, bookid);
        if (vocBook == null)
            return false;  //改单词在这个单词本
        else
            return true;
    }


    @RequestMapping(value = "/getUserBookOfAllWords", method = RequestMethod.GET)
    @ResponseBody
    List<VocBook> theUserBookOfAllWords(int bookid) {
        List<VocBook> vocBooks = userBookService.theUserBookOfAllWords(bookid);
        return vocBooks;
    }

    @RequestMapping(value = "/findUserById", method = RequestMethod.GET)
    @ResponseBody
    User findUserById(HttpServletRequest request) {
        int userid = Integer.parseInt(UserSessionCookieUtil.getUserIDSession(request));
        User user = userService.findUserById(userid);
        return user;
    }


}
