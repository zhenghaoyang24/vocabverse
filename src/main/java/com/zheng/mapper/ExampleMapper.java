package com.zheng.mapper;

import com.zheng.pojo.Example;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Insert;

import java.util.List;


public interface ExampleMapper {

    /*根据id搜索例句*/
    @Select("SELECT * FROM tb_voc_examples WHERE wordid  = #{wordid}")
    @Results({
            @Result(id = true, column = "exapid", property = "exapid"),
            @Result(column = "wordid", property = "wordid"),
            @Result(column = "en", property = "en"),
            @Result(column = "cn", property = "cn"),
            @Result(column = "heat", property = "heat"),
            @Result(column = "adddate", property = "adddate"),
            @Result(column = "holderid", property = "holderid"),
            @Result( property = "holder",column = "holderid",one = @One(select = "com.zheng.mapper.UserMapper.findUserNicknameByIdMapper")),
    })
    List<Example> findExampleByWordId(@Param("wordid") int wordid);


    /**
     * 修改热度
     * @param heat
     * @param exapid
     * @return
     */
    @Update("update tb_voc_examples set  heat = #{heat} where exapid = #{exapid}")
    boolean addHeat(@Param("heat") int heat,@Param("exapid") int exapid);


    /**
     * 添加例句
     */
    @Insert(value = "insert into tb_voc_examples(wordid,en,cn,heat,holderid,adddate) values (#{wordid},#{en},#{cn},#{heat},#{holderid},#{adddate});")
    boolean addExample(Example example);

    /*删除例句*/
    @Delete(value = "delete from tb_voc_examples where exapid = #{exapid}")
    boolean deleteExample(int exapid);


    /*更改例句*/
    @Update("update tb_voc_examples set en = #{en},cn=#{cn} where exapid = #{exapid}")
    boolean editExample(Example example);


}
