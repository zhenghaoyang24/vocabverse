package com.zheng.controller;

import com.zheng.pojo.Example;
import com.zheng.pojo.User;
import com.zheng.pojo.Word;
import com.zheng.service.ExampleService;
import com.zheng.service.UserService;
import com.zheng.service.WordService;
import com.zheng.utils.UserSessionCookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


    /**
     * 输入框动态查询单词
     *
     * @param inputText
     * @return
     */
    @RequestMapping(value = "/searchWordByInput", method = RequestMethod.GET)
    @ResponseBody
    public List<Word> searchWordByInput(String inputText) {
        System.out.println(inputText);
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
        System.out.println("wordid:" + wordid);
        Word word = wordService.findWordById(wordid);
        System.out.println(word);
        return word;
    }

    /**
     * 根据id搜索例句
     * @param wordid
     * @return
     */
    @RequestMapping(value = "/findExamplesByWordId", method = RequestMethod.GET)
    @ResponseBody
    public List<Example> findExamplesByWordId(int wordid) {
//        System.out.println(exampleService.findExampleByWordId(wordid));
        return exampleService.findExampleByWordId(wordid);
    }


    /**
     * 当前用户userid
     * @param request
     * @return
     */
    @RequestMapping(value = "/getUserId", method = RequestMethod.GET)
    @ResponseBody
    int getUserId(HttpServletRequest request) {
        String idSession = UserSessionCookieUtil.getUserIDSession(request);
        return Integer.parseInt(idSession);
    }


//    /**
//     * 根据例句的hoderid查找用户
//     * @param holderid
//     * @return
//     */
//    @RequestMapping(value = "/findUserByHolderid", method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
//    public String findUserByHoderid(int holderid, HttpServletResponse response) {
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//        User userById = userService.findUserById(holderid);
//        String usernickname = userById.getNickname();
//        return usernickname;
//    }
}
