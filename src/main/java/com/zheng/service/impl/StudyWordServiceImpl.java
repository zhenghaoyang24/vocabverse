package com.zheng.service.impl;

import com.zheng.mapper.StudyWordMapper;
import com.zheng.pojo.StudyWord;
import com.zheng.pojo.StudyWordRemenberHistory;
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
    public List<StudyWordRemenberHistory> getStudyWordRememberHistory(int wordid, int userid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudyWordMapper mapper = sqlSession.getMapper(StudyWordMapper.class);
        List<StudyWordRemenberHistory> history = mapper.getStudyWordRememberHistory(wordid, userid);
        sqlSession.close();
        return history;

    }
}
