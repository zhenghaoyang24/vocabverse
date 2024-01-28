package com.zheng.service.impl;

import com.zheng.mapper.BookMapper;
import com.zheng.mapper.BotMapper;
import com.zheng.mapper.ExampleMapper;
import com.zheng.pojo.Bot;
import com.zheng.pojo.Example;
import com.zheng.service.BotService;
import com.zheng.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotServiceImpl implements BotService {

    static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public Bot getBotById(String botid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BotMapper mapper = sqlSession.getMapper(BotMapper.class);
        Bot bot = mapper.getBotById(botid);
        sqlSession.close();
        return bot;
    }

    @Override
    public boolean addBotUsed(String botid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BotMapper mapper = sqlSession.getMapper(BotMapper.class);
        boolean b = mapper.addBotUsed(botid);
        sqlSession.close();
        return b;
    }

    @Override
    public boolean addLike(String botid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BotMapper mapper = sqlSession.getMapper(BotMapper.class);
        boolean b = mapper.addLike(botid);
        sqlSession.close();
        return b;
    }

    @Override
    public boolean addDislike(String botid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BotMapper mapper = sqlSession.getMapper(BotMapper.class);
        boolean b = mapper.addDislike(botid);
        sqlSession.close();
        return b;
    }
}
