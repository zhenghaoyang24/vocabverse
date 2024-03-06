package com.zheng.service;

import com.zheng.pojo.StudyWord;
import com.zheng.pojo.StudyWordRememberHistory;

import java.util.List;

public interface StudyWordService {

    StudyWord getStudyWordInformation(int wordid, int userid);

    boolean setStudyWordState(int state,int userid,int wordid);

    List<StudyWordRememberHistory> getStudyWordRememberHistory(int wordid, int userid);

    boolean addStudyWordService(int userid, int wordid, String adddate, String nextstudydate);

    boolean deleteTheStudyWord(int userid, int wordid);

    StudyWord getTodayStudyWord(int userid,String date);

    int getTodayStudyWordsCount(int userid,String date);

    boolean addStudyWordRememberHistory(StudyWordRememberHistory studyWordRemenberHistory);

    StudyWordRememberHistory getStudyWordRememberHistoryById(int userid, int wordid, String selectdate);

    boolean updateStudyWordInformation(StudyWord studyWord);

    boolean updateStudyWordExample(int userid, int wordid, int exapid);

    List<StudyWord> getTodayStudiedWords(int userid, String date);

}
