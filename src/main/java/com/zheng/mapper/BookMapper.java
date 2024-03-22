package com.zheng.mapper;

import com.zheng.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {


    @Select("SELECT * FROM tb_book")
    List<OfficialBook> getAllOfficialBook();

    @Select("SELECT * FROM tb_user_book where share = 1")
    List<UserBook> getAllShareUserBook();



    @Select("SELECT * FROM tb_user_book WHERE holderid  = #{holderid}")
    @Results({
            @Result(id = true, column = "userbookid", property = "userbookid"),
            @Result(column = "userbookname", property = "userbookname"),
            @Result(column = "voccount", property = "voccount"),
            @Result(column = "holderid", property = "holderid"),
            @Result(column = "creattime", property = "creattime"),
            @Result(column = "share", property = "share"),
            @Result(property = "holder", column = "holderid", one = @One(select = "com.zheng.mapper.UserMapper.findUserNicknameByIdMapper")),
    })
    List<UserBook> allMyUserBooks(@Param("holderid") int holderid);


    /*添加自定义书籍*/
    @Insert(value = "insert into tb_user_book(userbookname,voccount,holderid,creattime,share,bookdescribe) values (#{userbookname},#{voccount},#{holderid},#{creattime},#{share},#{bookdescribe})")
    boolean addUserBookMapper(UserBook userBook);


    /*加入单词到自定义书籍*/
    @Insert(value = "insert into tb_voc_userbook(wordid,bookid) value (#{wordid},#{bookid})")
    boolean addWordToUserBook(@Param("wordid") int wordid, @Param("bookid") int bookid);

    @Update("update tb_user_book set voccount = voccount+1 where userbookid = #{userbookid}")
    boolean addUserBookVocCount(@Param("userbookid")int userbookid);

    @Update("update tb_user_book set voccount = voccount-1 where userbookid = #{userbookid}")
    boolean subUserBookVocCount(@Param("userbookid")int userbookid);

    /*查看是否已经有这个单词*/
    @Select("SELECT * FROM tb_voc_userbook WHERE wordid  = #{wordid} and bookid = #{bookid}")
    @Results({
            @Result(id = true, column = "ubookvocid", property = "id"),
            @Result(column = "wordid", property = "wordid"),
            @Result(column = "bookid", property = "bookid")
    })
    VocBook judgeTheWordInTheBook(@Param("wordid") int wordid, @Param("bookid") int bookid);

    @Select("SELECT * FROM tb_voc_userbook WHERE bookid  = #{bookid}")
    @Results({
            @Result(id = true, column = "ubookvocid", property = "id"),
            @Result(column = "bookid", property = "bookid"),
            @Result(column = "wordid", property = "wordid"),
            @Result(
                    property = "word",
                    column = "wordid",
                    javaType = Word.class,
                    one = @One(select = "com.zheng.mapper.VocabularyMapper.findWordById")
            )
    })
    List<VocBook> theUserBookOfAllWords(int bookid);


    @Select("SELECT * FROM tb_voc_book WHERE bookid  = #{bookid}")
    @Results({
            @Result(id = true, column = "vocbkid", property = "id"),
            @Result(column = "bookid", property = "bookid"),
            @Result(column = "wordid", property = "wordid"),
            @Result(
                    property = "word",
                    column = "wordid",
                    javaType = Word.class,
                    one = @One(select = "com.zheng.mapper.VocabularyMapper.findWordById")
            )
    })
    List<VocBook> theOfficialBookOfAllWords(int bookid);



    @Delete(value = "delete from tb_voc_userbook where wordid = #{wordid} and bookid = #{bookid}")
    boolean deleteWordFromUserBookMapper(@Param("wordid") int wordid,@Param("bookid") int bookid);


    //删除某词库所有单词
    @Delete("delete from tb_voc_userbook where bookid = #{bookid}")
    boolean deleteTheUserBookOfAllWords(@Param("bookid") int bookid);


    //用户删除某词库  删除后必须删除所有单词
    @Delete("delete from tb_user_book where userbookid = #{userbookid} and holderid = #{holderid}")
    boolean deleteTheUserBookById(@Param("userbookid") int userbookid ,@Param("holderid") int holderid);

    @Update("update tb_user_book set userbookname = #{userbookname} ,bookdescribe = #{bookdescribe},share = #{share} where userbookid = #{userbookid} and holderid = #{holderid} ")
    boolean updateTheUserBookInfo(@Param("userbookname") String userbookname ,@Param("bookdescribe") String bookdescribe ,@Param("share") int share,@Param("userbookid") int userbookid ,@Param("holderid") int holderid);



}
