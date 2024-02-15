package com.zheng.mapper;

import com.zheng.pojo.StudyWord;
import com.zheng.pojo.StudyWordRemenberHistory;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudyWordMapper {

    @Select("select * from  tb_voc_study where wordid = #{wordid} and userid=#{userid}")
    StudyWord getStudyWordInformationById(@Param("wordid") int wordid, @Param("userid") int userid);

    @Update("update tb_voc_study set state = #{state} where  userid=#{userid} and wordid = #{wordid}")
    boolean setStudyWordState(@Param("state") int state, @Param("userid") int userid, @Param("wordid") int wordid);

    @Select("select * from tb_voc_study_history where userid=#{userid} and wordid = #{wordid}")
    List<StudyWordRemenberHistory> getStudyWordRememberHistory(@Param("wordid") int wordid, @Param("userid") int userid);





}
