package com.zheng.service.impl;


import com.zheng.mapper.VocabularyMapper;
import com.zheng.pojo.SearchWordHistory;
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

    @Override
    public boolean addSearchTimes(int wordid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        VocabularyMapper mapper = sqlSession.getMapper(VocabularyMapper.class);
        boolean b = mapper.addSearchTimes(wordid);
        sqlSession.close();
        return b;
    }


    /*
    单词历史
    */

    /**
     * 添加单词历史
     * @param history
     * @return
     */
    @Override
    public boolean addSearchedWordHistory(SearchWordHistory history) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        VocabularyMapper mapper = sqlSession.getMapper(VocabularyMapper.class);
        SearchWordHistory searchWordHistory = mapper.judgSearchWordHistory(history.getWordid(), history.getUserid());
        if (searchWordHistory!=null){   //判断该用户是否已经有单词历史
            sqlSession.close();
            return false;
        }else{
            boolean b = mapper.addSearchedWordHistory(history);
            sqlSession.close();
            return b;
        }
    }

    /**
     * 所有单词历史
     * @param userid
     * @return
     */
    @Override
    public List<SearchWordHistory> getAllSearchWordHistory(int userid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        VocabularyMapper mapper = sqlSession.getMapper(VocabularyMapper.class);
        List<SearchWordHistory> list = mapper.getAllSearchWordHistory(userid);
        sqlSession.close();
        return list;
    }

    /**
     * 删除一个单词历史
     * @param wordid
     * @param userid
     * @return
     */
    @Override
    public boolean deleteSearchWordHistory(int wordid, int userid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        VocabularyMapper mapper = sqlSession.getMapper(VocabularyMapper.class);
        boolean b = mapper.deleteSearchWordHistory(wordid, userid);
        sqlSession.close();
        return b;
    }

    /**
     * 删除所有单词历史
     * @param userid
     * @return
     */
    @Override
    public boolean deleteAllSearchWordHistory(int userid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        VocabularyMapper mapper = sqlSession.getMapper(VocabularyMapper.class);
        boolean b = mapper.deleteAllSearchWordHistory(userid);
        sqlSession.close();
        return b;
    }

    @Override
    public List<Word> getWordsSearchTimesRank() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        VocabularyMapper mapper = sqlSession.getMapper(VocabularyMapper.class);
        List<Word> timesRank = mapper.getWordsSearchTimesRank();
        sqlSession.close();
        return timesRank;
    }

    @Override
    public List<Word> getWordsStudyTimesRank() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        VocabularyMapper mapper = sqlSession.getMapper(VocabularyMapper.class);
        List<Word> timesRank = mapper.getWordsStudyTimesRank();
        sqlSession.close();
        return timesRank;
    }


}
