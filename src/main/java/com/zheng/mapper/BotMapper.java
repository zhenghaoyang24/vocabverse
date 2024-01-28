package com.zheng.mapper;

import com.zheng.pojo.Bot;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BotMapper {

    @Select("SELECT * FROM tb_bot WHERE botid  = #{botid}")
    Bot getBotById(String botid);

    @Update("update tb_bot set usedcount = usedcount+1 where botid  = #{botid}")
    boolean addBotUsed(String botid);

    @Update("update tb_bot set likecount = likecount+1 ,satisfaction =likecount/(likecount+dislikecount) where botid  = #{botid}")
    boolean addLike(String botid);

    @Update("update tb_bot set dislikecount = dislikecount+1 ,satisfaction =likecount/(likecount+dislikecount) where botid  = #{botid}")
    boolean addDislike(String botid);

}
