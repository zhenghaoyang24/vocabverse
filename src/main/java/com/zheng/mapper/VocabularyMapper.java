package com.zheng.mapper;

import com.zheng.pojo.SearchWordHistory;
import com.zheng.pojo.Word;
import org.apache.ibatis.annotations.*;

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

    @Update("update tb_vocabulary set searchtimes = searchtimes+1 where wordid = #{wordid}")
    boolean addSearchTimes(@Param("wordid") int wordid);


    /*
    单词搜索历史
    */
    @Insert(value = "insert into tb_voc_history(userid,wordid,spelling) values (#{userid},#{wordid},#{spelling});")
    boolean addSearchedWordHistory(SearchWordHistory history);
    @Select(value = ("select * from tb_voc_history where wordid=#{wordid} and userid=#{userid}"))
    SearchWordHistory judgSearchWordHistory(@Param("wordid") int wordid, @Param("userid") int userid);
    @Select("select * from tb_voc_history where userid = #{userid}")
    List<SearchWordHistory> getAllSearchWordHistory(int userid);
    @Update("delete from tb_voc_history where wordid=#{wordid} and userid=#{userid}")
    boolean deleteSearchWordHistory(@Param("wordid") int wordid, @Param("userid") int userid);

    @Update("delete from tb_voc_history where userid=#{userid}")
    boolean deleteAllSearchWordHistory(@Param("userid") int userid);

    @Select("SELECT * FROM tb_vocabulary order by searchtimes desc limit 15")
    List<Word> getWordsSearchTimesRank();

    @Select("SELECT * FROM tb_vocabulary order by studytimes desc limit 15")
    List<Word> getWordsStudyTimesRank();


}
