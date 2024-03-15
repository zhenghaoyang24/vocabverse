package com.zheng.service.impl;

import com.zheng.mapper.BookMapper;
import com.zheng.pojo.UserBook;
import com.zheng.pojo.VocBook;
import com.zheng.service.UserBookService;
import com.zheng.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.test.context.TestExecutionListeners;

import java.util.List;


@Service
public class UserBookServiceImpl implements UserBookService {

    static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<UserBook> allMyUserBooks(int holderid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<UserBook> userBooks = mapper.allMyUserBooks(holderid);
        sqlSession.close();
        return userBooks;
    }

    @Override
    public boolean addUserBookMapper(UserBook userBook) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        boolean b = mapper.addUserBookMapper(userBook);
        sqlSession.close();
        return b;
    }

    @Override
    public boolean addWordToUserBook(int wordid, int userbookid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        boolean b = mapper.addWordToUserBook(wordid, userbookid);
        if (b){
            mapper.addUserBookVocCount(userbookid);
        }
        sqlSession.close();
        return b;
    }

    @Override
    public VocBook judgeTheWordInTheBook(int wordid, int bookid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        VocBook vocBook = mapper.judgeTheWordInTheBook(wordid, bookid);
        sqlSession.close();
        return vocBook;
    }

    @Override
    public List<VocBook> theUserBookOfAllWords(int bookid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<VocBook> vocBooks = mapper.theBookOfAllWords(bookid);
        sqlSession.close();
        return vocBooks;
    }

    @Override
    public boolean deleteWordFromUserBookMapper(int wordid, int bookid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        boolean b = mapper.deleteWordFromUserBookMapper(wordid, bookid);
        if (b){
            mapper.subUserBookVocCount(bookid);
        }
        sqlSession.close();
        return b;
    }
}
