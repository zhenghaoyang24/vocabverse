package com.zheng.service;

import com.zheng.pojo.Daily;
import com.zheng.pojo.StudyDataInfoSum;

import java.util.List;

public interface DailyService {
    Daily getDaily(int userid, String time);

    boolean creatDaily(Daily daily);


    boolean addSearchedWordCount(int userid, String time);

    boolean setShouldStudy(int shouldstudy, int userid, String time);

    boolean updateDailyFeedbackDate(Daily daily);

    boolean checkinDaily(int userid, String time);


    List<Daily> getDailyListByUserid(int userid);
}
