package com.zheng.service.impl;

import com.zheng.mapper.BookMapper;
import com.zheng.pojo.UserBook;
import com.zheng.pojo.VocBook;
import com.zheng.service.UserBookService;
import com.zheng.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserBookServiceImpl implements UserBookService {

    static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    //获取所有共享词库
    @Override
    public List<UserBook> getAllShareUserBook() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<UserBook> userBooks = mapper.getAllShareUserBook();
        sqlSession.close();
        return userBooks;
    }

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
        if (b) {
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
        List<VocBook> vocBooks = mapper.theUserBookOfAllWords(bookid);
        sqlSession.close();
        return vocBooks;
    }

    @Override
    public boolean deleteWordFromUserBookMapper(int wordid, int bookid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        boolean b = mapper.deleteWordFromUserBookMapper(wordid, bookid);
        if (b) {
            mapper.subUserBookVocCount(bookid);
        }
        sqlSession.close();
        return b;
    }

    @Override
    public boolean deleteTheUserBookAndAllWords(int bookid, int holderid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        mapper.deleteTheUserBookOfAllWords(bookid);  //删除单词
        boolean b = mapper.deleteTheUserBookById(bookid, holderid);  //删除词库
        sqlSession.close();
        return b;
    }

    @Override
    public boolean updateTheUserBookInfo(String userbookname, String bookdescribe, int share, int userbookid, int holderid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        boolean b = mapper.updateTheUserBookInfo(userbookname, bookdescribe, share, userbookid, holderid);
        sqlSession.close();
        return b;
    }
}
