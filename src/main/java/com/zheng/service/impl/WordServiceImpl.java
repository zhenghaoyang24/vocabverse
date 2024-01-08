package com.zheng.service.impl;

import com.zheng.mapper.UserMapper;
import com.zheng.mapper.VocabularyMapper;
import com.zheng.pojo.Example;
import com.zheng.pojo.User;
import com.zheng.pojo.Word;
import com.zheng.service.WordService;
import com.zheng.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {


    static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Word> findWordByLetterEn(String letter) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        VocabularyMapper mapper = sqlSession.getMapper(VocabularyMapper.class);
        List<Word> byLetter = mapper.findByLetterEn(letter);
        sqlSession.close();
        return byLetter;
    }

    @Override
    public List<Word> findWordByLetterCn(String letter) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        VocabularyMapper mapper = sqlSession.getMapper(VocabularyMapper.class);
        List<Word> byLetter = mapper.findByLetterCn(letter);
        sqlSession.close();
        return byLetter;
    }

    @Override
    public Word findWordById(int wordid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        VocabularyMapper mapper = sqlSession.getMapper(VocabularyMapper.class);
        Word wordById = mapper.findWordById(wordid);
        sqlSession.close();
        return wordById;
    }




}
