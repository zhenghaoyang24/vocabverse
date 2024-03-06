package com.zheng.service.impl;

import com.zheng.mapper.StudyWordMapper;
import com.zheng.pojo.StudyWord;
import com.zheng.pojo.StudyWordRememberHistory;
import com.zheng.service.StudyWordService;
import com.zheng.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudyWordServiceImpl implements StudyWordService {

    static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查找单个规划单词的信息
     *
     * @param wordid
     * @param userid
     * @return
     */
    @Override
    public StudyWord getStudyWordInformation(int wordid, int userid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        StudyWord studyWord = mapper.getStudyWordInformationById(wordid, userid);
        sqlSession.close();
        return studyWord;
    }

    @Override
    public boolean setStudyWordState(int state, int userid, int wordid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        boolean b = mapper.setStudyWordState(state, userid, wordid);
        sqlSession.close();
        return b;
    }

    @Override
    public List<StudyWordRememberHistory> getStudyWordRememberHistory(int wordid, int userid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        List<StudyWordRememberHistory> history = mapper.getStudyWordRememberHistory(wordid, userid);
        sqlSession.close();
        return history;

    }

    @Override
    public boolean addStudyWordService(int userid, int wordid, String adddate, String nextstudydate) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        boolean b = mapper.addStudyWordMapper(userid, wordid, adddate, nextstudydate);
        sqlSession.close();
        return b;
    }

    @Override
    public boolean deleteTheStudyWord(int userid, int wordid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        boolean b = mapper.deleteStudyWordMapper(userid, wordid);
        mapper.deleteStudyWordRemenberHistory(userid, wordid);
        sqlSession.close();
        return b;

    }

    @Override
    public StudyWord getTodayStudyWord(int userid, String date) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        StudyWord studyWords = mapper.getTodayStudyWord(userid, date);
        sqlSession.close();
        return studyWords;
    }

    @Override
    public int getTodayStudyWordsCount(int userid, String date) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        int count = mapper.getTodayStudyWordsCount(userid, date);
        sqlSession.close();
        return count;
    }

    @Override
    public boolean addStudyWordRememberHistory(StudyWordRememberHistory studyWordRemenberHistory) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        boolean b = mapper.addStudyWordRememberHistory(studyWordRemenberHistory);
        sqlSession.close();
        return b;
    }

    @Override
    public StudyWordRememberHistory getStudyWordRememberHistoryById(int userid, int wordid, String selectdate) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        StudyWordRememberHistory studyWordRememberHistory = mapper.getStudyWordRememberHistoryById(userid, wordid, selectdate);
        sqlSession.close();
        return studyWordRememberHistory;
    }

    @Override
    public boolean updateStudyWordInformation(StudyWord studyWord) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        boolean b = mapper.updateStudyWordInformation(studyWord);
        sqlSession.close();
        return b;
    }

    @Override
    public boolean updateStudyWordExample(int userid, int wordid, int exapid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        boolean b = mapper.updateStudyWordExample(userid, wordid, exapid);
        sqlSession.close();
        return b;
    }

    @Override
    public List<StudyWord> getTodayStudiedWords(int userid, String date) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        List<StudyWord> todayStudiedWords = mapper.getTodayStudiedWords(userid, date);
        sqlSession.close();
        return todayStudiedWords;
    }
}
