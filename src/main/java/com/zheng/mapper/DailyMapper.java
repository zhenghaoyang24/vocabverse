package com.zheng.mapper;

import com.zheng.pojo.Daily;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DailyMapper {

    @Select("SELECT * FROM tb_daily WHERE userid = #{userid} and time = #{time}")
    Daily getDailyByUseridAndTime(@Param("userid") int userid,@Param("time") String time);

    @Insert(value = "insert into tb_daily(userid,time,checkin,searchedword,studyword,studytime) values (#{userid},#{time},#{checkin},#{searchedword},#{studyword},#{studytime});")
    boolean creatDaily(Daily daily);

    @Update("update tb_daily set searchedword =searchedword+1 WHERE userid = #{userid} and time = #{time}")
    boolean addSearchedWordCount(@Param("userid") int userid, @Param("time") String time);




}
