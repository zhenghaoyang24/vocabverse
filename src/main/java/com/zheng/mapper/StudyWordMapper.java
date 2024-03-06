package com.zheng.mapper;

import com.zheng.pojo.StudyWord;
import com.zheng.pojo.StudyWordRememberHistory;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudyWordMapper {

    @Select("select * from  tb_voc_study where wordid = #{wordid} and userid=#{userid}")
    @Results({
            @Result(column = "wordid", property = "wordid"),
            @Result(column = "exapid", property = "exapid"),
            @Result( property = "example",column = "exapid",one = @One(select = "com.zheng.mapper.ExampleMapper.findExampleByExapid")),
            @Result( property = "word",column = "wordid",one = @One(select = "com.zheng.mapper.VocabularyMapper.findWordById")),
    })
    StudyWord getStudyWordInformationById(@Param("wordid") int wordid, @Param("userid") int userid);


    @Update("update tb_voc_study set state = #{state} where  userid=#{userid} and wordid = #{wordid}")
    boolean setStudyWordState(@Param("state") int state, @Param("userid") int userid, @Param("wordid") int wordid);

    @Select("select * from tb_voc_study_history where userid=#{userid} and wordid = #{wordid}")
    List<StudyWordRememberHistory> getStudyWordRememberHistory(@Param("wordid") int wordid, @Param("userid") int userid);

    //加入学习计划
    @Insert("insert into tb_voc_study(userid,wordid,adddate,nextstudydate) values (#{userid},#{wordid},#{adddate},#{nextstudydate})")
    boolean addStudyWordMapper(@Param("userid") int userid, @Param("wordid") int wordid, @Param("adddate") String adddate, @Param("nextstudydate") String nextstudydate);


    /*移除规划*/
    @Delete("delete  from  tb_voc_study where   userid=#{userid} and wordid = #{wordid}")
    boolean deleteStudyWordMapper(@Param("userid") int userid, @Param("wordid") int wordid);

    /*删除学习记忆历史记录*/
    @Delete("delete  from  tb_voc_study_history where   userid=#{userid} and wordid = #{wordid}")
    boolean deleteStudyWordRemenberHistory(@Param("userid") int userid, @Param("wordid") int wordid);

    @Insert("insert into tb_voc_study_history values(#{userid},#{wordid},#{opt},#{selectdate})")
    boolean addStudyWordRememberHistory(StudyWordRememberHistory studyWordRemenberHistory);

    @Select("select * from tb_voc_study_history where userid=#{userid} and  wordid=#{wordid} and  selectdate=#{selectdate}")
    StudyWordRememberHistory getStudyWordRememberHistoryById(@Param("userid") int userid,@Param("wordid") int wordid,@Param("selectdate") String  selectdate);

    @Select("select * from tb_voc_study where userid=#{userid} and Date(nextstudydate)<=#{date} and state = 0 ORDER BY ef DESC LIMIT 1")
    @Results({
            @Result(column = "wordid", property = "wordid"),
            @Result(column = "exapid", property = "exapid"),
            @Result( property = "example",column = "exapid",one = @One(select = "com.zheng.mapper.ExampleMapper.findExampleByExapid")),
            @Result( property = "word",column = "wordid",one = @One(select = "com.zheng.mapper.VocabularyMapper.findWordById")),
    })
    StudyWord getTodayStudyWord(@Param("userid") int userid, @Param("date") String date);

    @Select("select * from tb_voc_study where userid=#{userid} and laststudydate=#{date} and state = 0")
    @Results({
            @Result(column = "wordid", property = "wordid"),
            @Result(column = "exapid", property = "exapid"),
            @Result( property = "example",column = "exapid",one = @One(select = "com.zheng.mapper.ExampleMapper.findExampleByExapid")),
            @Result( property = "word",column = "wordid",one = @One(select = "com.zheng.mapper.VocabularyMapper.findWordById")),
    })
    List<StudyWord> getTodayStudiedWords(@Param("userid") int userid, @Param("date") String date);

    @Select("select count(*) from tb_voc_study where userid=#{userid} and Date(nextstudydate)<=#{date} and state = 0 ORDER BY ef LIMIT 1")
    int getTodayStudyWordsCount(@Param("userid") int userid, @Param("date") String date);

    @Update("update tb_voc_study set q_0=#{q_0} ,q_1=#{q_1},q_2=#{q_2},q_3=#{q_3},studycount=#{studycount},ef=#{ef},day_q_0=#{day_q_0},day_q_1=#{day_q_1},day_q_2=#{day_q_2},day_studycount=#{day_studycount},intervalday=#{intervalday},laststudydate=#{laststudydate},nextstudydate=#{nextstudydate} where userid=#{userid} and wordid=#{wordid}")
    boolean updateStudyWordInformation(StudyWord studyWord);

    @Update("update tb_voc_study set exapid = #{exapid} where userid = #{userid} and wordid = #{wordid}")
    boolean updateStudyWordExample( @Param("userid") int userid,@Param("wordid") int wordid,@Param("exapid") int exapid);





}
