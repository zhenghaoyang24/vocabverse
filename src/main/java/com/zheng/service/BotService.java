package com.zheng.service;


import com.zheng.pojo.Bot;

public interface BotService {

    Bot getBotById(String botid);

    boolean addBotUsed(String botid);

    boolean addLike(String botid);

    boolean addDislike(String botid);


}
