package com.zheng.service.impl;

import com.zheng.mapper.BotMapper;
import com.zheng.mapper.DailyMapper;
import com.zheng.pojo.Bot;
import com.zheng.pojo.Daily;
import com.zheng.service.DailyService;
import com.zheng.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

@Service
public class DailyServiceImpl implements DailyService {

    static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public Daily getDaily(int userid, String time) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DailyMapper mapper = sqlSession.getMapper(DailyMapper.class);
        Daily daily = mapper.getDailyByUseridAndTime(userid, time);
        sqlSession.close();
        return daily;
    }

    @Override
    public boolean creatDaily(Daily daily) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DailyMapper mapper = sqlSession.getMapper(DailyMapper.class);
        boolean b = mapper.creatDaily(daily);
        sqlSession.close();
        return b;
    }

    @Override
    public boolean addSearchedWordCount(int userid, String time) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DailyMapper mapper = sqlSession.getMapper(DailyMapper.class);
        boolean b = mapper.addSearchedWordCount(userid, time);
        sqlSession.close();
        return b;
    }

    @Override
    public boolean setShouldStudy(int shouldstudy, int userid, String time) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DailyMapper mapper = sqlSession.getMapper(DailyMapper.class);
        boolean b = mapper.setShouldStudy(shouldstudy,userid, time);
        sqlSession.close();
        return b;
    }


    /*设置学习次数 单词数 时间  反馈时*/
    @Override
    public boolean updateDailyFeedbackDate(Daily daily) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DailyMapper mapper = sqlSession.getMapper(DailyMapper.class);
        boolean b = mapper.updateDailyFeedbackDate(daily);
        sqlSession.close();
        return b;
    }
}
