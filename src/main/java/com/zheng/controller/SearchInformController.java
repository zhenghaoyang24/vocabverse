package com.zheng.controller;

import com.zheng.pojo.Example;
import com.zheng.pojo.Word;
import com.zheng.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchInformController {


    @Autowired
    protected WordService wordService;


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
        return word;
    }

    @RequestMapping(value = "/findExamplesByWordId", method = RequestMethod.GET)
    @ResponseBody
    public List<Example> findExamplesByWordId(int wordid) {
        List<Example> exampleList = wordService.findExampleByWordId(wordid);
//        System.out.println(exampleList);
        return exampleList;
    }
}
