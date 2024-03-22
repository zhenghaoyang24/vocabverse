package com.zheng.service;

import com.zheng.pojo.OfficialBook;
import com.zheng.pojo.VocBook;

import java.util.List;

public interface OfficialBookService {

    List<OfficialBook> getAllOfficialBook();
    List<VocBook> theOfficialBookOfAllWords(int bookid);

}
