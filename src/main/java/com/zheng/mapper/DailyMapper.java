package com.zheng.mapper;

import com.zheng.pojo.Daily;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DailyMapper {

    @Select("SELECT * FROM tb_daily WHERE userid = #{userid} and time = #{time}")
    Daily getDailyByUseridAndTime(@Param("userid") int userid,@Param("time") String time);

    @Insert(value = "insert into tb_daily(userid,time,shouldstudy) values (#{userid},#{time},#{shouldstudy});")
    boolean creatDaily(Daily daily);

    @Update("update tb_daily set searchedword =searchedword+1 WHERE userid = #{userid} and time = #{time}")
    boolean addSearchedWordCount(@Param("userid") int userid, @Param("time") String time);

    @Update("update tb_daily set studyword =#{studyword} ,studytime =#{studytime},studyduration =#{studyduration}  WHERE userid = #{userid} and time = #{time}")
    boolean updateDailyFeedbackDate(Daily daily);

    @Update("update tb_daily set shouldstudy = #{shouldstudy} where userid = #{userid} and time = #{time}")
    boolean setShouldStudy(@Param("shouldstudy")int shouldstudy,@Param("userid")int userid,@Param("time")String time);


    @Update("update  tb_daily set checkin = 1 where userid = #{userid} and time = #{time}")
    boolean checkinDaily(@Param("userid")int userid,@Param("time")String time);


}
