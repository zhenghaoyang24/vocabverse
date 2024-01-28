package com.zheng.mapper;

import com.zheng.pojo.Example;
import com.zheng.pojo.UserBook;
import com.zheng.pojo.VocBook;
import com.zheng.pojo.Word;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {

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
    List<VocBook> theBookOfAllWords(int bookid);

    @Delete(value = "delete from tb_voc_userbook where wordid = #{wordid} and bookid = #{bookid}")
    boolean deleteWordFromUserBookMapper(@Param("wordid") int wordid,@Param("bookid") int bookid);



}
