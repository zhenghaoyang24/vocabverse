package com.zheng.service.impl;

import com.zheng.mapper.BookMapper;
import com.zheng.pojo.OfficialBook;
import com.zheng.pojo.VocBook;
import com.zheng.service.OfficialBookService;
import com.zheng.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficialBookServiceImpl implements OfficialBookService {

    static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<OfficialBook> getAllOfficialBook() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<OfficialBook> officialBooks = mapper.getAllOfficialBook();
        sqlSession.close();
        return officialBooks;
    }

    @Override
    public List<VocBook> theOfficialBookOfAllWords(int bookid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<VocBook> vocBooks = mapper.theOfficialBookOfAllWords(bookid);
        return vocBooks;
    }
}
