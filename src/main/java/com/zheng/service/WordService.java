package com.zheng.service;

import com.zheng.pojo.Example;
import com.zheng.pojo.SearchWordHistory;
import com.zheng.pojo.Word;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordService {

    List<Word> findWordByLetterEn(String letter);

    List<Word> findWordByLetterCn(String letter);

    Word findWordById(int wordid);

    boolean addSearchTimes(int wordid);

    /*
    单词历史
    */
    boolean addSearchedWordHistory(SearchWordHistory history);
    List<SearchWordHistory> getAllSearchWordHistory(int userid);
    boolean deleteSearchWordHistory(int wordid,int userid);
    boolean deleteAllSearchWordHistory(int userid);

    List<Word> getWordsSearchTimesRank();
    List<Word> getWordsStudyTimesRank();

    /*更改学习人数*/
    boolean updateWordStudyTime(int wordid, String type);

}
