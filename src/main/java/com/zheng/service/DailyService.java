package com.zheng.service;

import com.zheng.pojo.Daily;

public interface DailyService {
    Daily getDaily(int userid, String time);

    boolean creatDaily(Daily daily);


    boolean addSearchedWordCount(int userid, String time);
}
