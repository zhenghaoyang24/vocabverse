package com.zheng.service;

import com.zheng.pojo.Example;
import com.zheng.pojo.Word;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordService {

    List<Word> findWordByLetterEn(String letter);

    List<Word> findWordByLetterCn(String letter);

    Word findWordById(int wordid);

}
