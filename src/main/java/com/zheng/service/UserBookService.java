package com.zheng.service;

import com.zheng.pojo.UserBook;
import com.zheng.pojo.VocBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;



public interface UserBookService {

    List<UserBook> getAllShareUserBook();

    List<UserBook> allMyUserBooks(int holderid);

    boolean addUserBookMapper(UserBook userBook);

    boolean addWordToUserBook(int wordid, int userbookid);

    VocBook judgeTheWordInTheBook(int wordid, int bookid);

    List<VocBook> theUserBookOfAllWords(int bookid);

    boolean deleteWordFromUserBookMapper(int wordid, int bookid);

    boolean deleteTheUserBookAndAllWords(int bookid, int holderid);

    boolean updateTheUserBookInfo(String userbookname ,String bookdescribe ,int share,int userbookid ,int holderid);



}
