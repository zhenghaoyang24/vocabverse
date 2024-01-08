package com.zheng.mapper;

import com.zheng.pojo.Example;
import com.zheng.pojo.Word;
import com.zheng.service.WordService;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface VocabularyMapper {


    /*根据英文搜索单词*/
    @Select("SELECT * FROM tb_vocabulary WHERE spelling LIKE CONCAT(#{letter}, '%') ORDER BY frequency  DESC LIMIT 50 ")
    List<Word> findByLetterEn(@Param("letter") String letter);

    /*根据中文搜索单词*/
    @Select("SELECT * FROM tb_vocabulary WHERE paraphrase LIKE CONCAT('%',#{letter},'%') LIMIT 50")
    List<Word> findByLetterCn(@Param("letter") String letter);

    /*根据id搜索单词*/
    @Select("SELECT * FROM tb_vocabulary WHERE wordid  = #{wordid}")
    Word findWordById(@Param("wordid") int wordid);






}
