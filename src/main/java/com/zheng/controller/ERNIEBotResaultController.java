package com.zheng.controller;

import com.zheng.pojo.Bot;
import com.zheng.service.BotService;
import com.zheng.utils.ERNIEBotUtils;
import kotlin.ParameterName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.util.Length;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

@Controller
@RequestMapping("/getERNIEBotStudy")
public class ERNIEBotResaultController {

    @Autowired
    BotService botService;

    String result = null;

    @RequestMapping(value = "/bot_feedback", method = RequestMethod.POST)
    @ResponseBody
    public void bot_feedback(String category, String feedbackvalue) {
        if (feedbackvalue.equals("yes"))
            botService.addLike(category);
        if (feedbackvalue.equals("no"))
            botService.addDislike(category);
    }

    @RequestMapping(value = "/bot_used", method = RequestMethod.POST)
    @ResponseBody
    public void bot_used(String category) {
        botService.addBotUsed(category);
    }

    @RequestMapping(value = "/get_bot", method = RequestMethod.GET)
    @ResponseBody
    public Bot get_bot(String category) {
        return botService.getBotById(category);
    }


    @RequestMapping(value = "/xiezuo_making", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String xiezuo_making(String xiezuoTitle, String zishuLength, String levelValue) throws InterruptedException, ExecutionException {
        System.out.println("RequestMapping xiezuo_making");
        String commend = "写一篇题目为" + xiezuoTitle + "，要求" + zishuLength + "个单词，" + levelValue + "水平，英语作文，最后给出中文翻译。";
        //创建线程池
        return myBotCallable(commend);
    }

    @RequestMapping(value = "/zaoju_making", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String zaoju_making(@RequestParam List<String> zaojuWords) throws ExecutionException, InterruptedException {
        System.out.println("RequestMapping zaoju_making --");
        String words = "";
        for (int i = 0; i < zaojuWords.size() - 1; i++) {
            words = words + zaojuWords.get(i) + "、";
        }
        words = words + zaojuWords.get(zaojuWords.size() - 1);
        String commend = "单词：" + words + "。分别给出单词释义，从声形等方法给出记住这些单词的建议，并利用这几个单词一起造一个英语句子，且把句子翻译为中文";
        return myBotCallable(commend);
    }


    @RequestMapping(value = "/runse_making", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String runse_making(String runse_sentence) throws ExecutionException, InterruptedException {
        System.out.println("RequestMapping runse_making --");
        String commend = runse_sentence + ", 润色这个英语句子，并将润色后的句子翻译为中文，并给出更改理由";
        return myBotCallable(commend);
    }


    @RequestMapping(value = "/wenda_making", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String wenda_making(String wenda_question) throws ExecutionException, InterruptedException {
        System.out.println("RequestMapping wenda_making --");
        String commend = "问题：" + wenda_question + "。若问题与英语学习相关则详细回答" + "若不相关则提醒应该问与英语学习相关的问题。";
        return myBotCallable(commend);
    }


    /*请求API线程*/
    protected String myBotCallable(String commend) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        //创建callable任务
        Callable<String> stringCallable = () -> {
            result = String.valueOf(ERNIEBotUtils.getERNIEBotResault(commend));
            return result;
        };
        Future<String> future = executor.submit(stringCallable);
        String result = future.get();
        return result;
    }
}

