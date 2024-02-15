package com.zheng.service;

import com.zheng.pojo.StudyWord;
import com.zheng.pojo.StudyWordRemenberHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudyWordService {

    StudyWord getStudyWordInformation(int wordid, int userid);

    boolean setStudyWordState(int state,int userid,int wordid);

    List<StudyWordRemenberHistory> getStudyWordRememberHistory(int wordid,int userid);
}
