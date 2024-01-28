package com.zheng.service;

import com.zheng.pojo.UserBook;
import com.zheng.pojo.VocBook;
import org.springframework.stereotype.Service;

import java.util.List;



public interface UserBookService {

    List<UserBook> allMyUserBooks(int holderid);

    boolean addUserBookMapper(UserBook userBook);

    boolean addWordToUserBook(int wordid, int userbookid);

    VocBook judgeTheWordInTheBook(int wordid, int bookid);

    List<VocBook> theUserBookOfAllWords(int bookid);

    boolean deleteWordFromUserBookMapper(int wordid, int bookid);



}
