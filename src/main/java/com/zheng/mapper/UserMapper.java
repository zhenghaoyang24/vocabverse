package com.zheng.mapper;



import com.zheng.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    /*登录*/
    @Select(value = "select * from tb_user where useremail = #{useremail} and userpassword = #{userpassword}")
    User findUserByNameAndEmail(@Param("useremail") String useremail, @Param("userpassword") String userpassword);


    /*注册*/
    @Insert(value = "insert into tb_user(userid,nickname,useremail,userpassword,regtime) values (#{userid},#{nickname},#{useremail},#{userpassword},#{regtime});")
    void userSignUpMapper(User user);

    /*根据id查找用户*/
    @Select(value = "select * from tb_user where userid = #{userid}")
    User findUserByIdMapper(@Param("userid") int userid);

    @Select(value = "select * from tb_user where useremail = #{useremail}")
    User findUserByUserEmailMapper(@Param("useremail") String useremail);
//
//    @Update(value = "update tb_user set username=#{username},password=#{password} where id=#{id}")
//    public void update(User user);
//
//
//    @Delete(value = "delete from tb_user where id=#{id}")
//    public void delete(int id);
//
//
//    @Select(value = "select * from tb_user where id=#{id}")
//    public User findById(int id);
//
//
//    @Select("select * from tb_user")
//    public List<User> findAll();


//    //登录查询
//    @Select("select * from tb_user where username=#{username} and password=#{password}")
//    public User findUserByNamePassword(@Param("username") String username, @Param("password") String password);
//
//    @Select("select * from tb_user where username=#{username}")
//    public User findUserByUserNmae(@Param("username") String username);
//
//    /*根据id获取信息*/
//    @Select("select * from tb_user where userid=#{userid}")
//    public User findById(@Param("userid") int userid);
//
//    @Update(value = "update tb_user set userrealname=#{userrealname},userage=#{userage},usersex=#{usersex}" +
//            ",useridentity=#{useridentity},userphone=#{userphone},useremail=#{useremail}" +
//            ",identitynumber=#{identitynumber},useraddres=#{useraddres}" +
//            ",userbirthday=#{userbirthday},regtime=#{regtime} where userid=#{userid};")
//    void updateUserInfo(User user);
//
//
//    /*注册*/
//    @Insert(value = "insert into tb_user(username,password,useremail,regtime,ipaddress) values (#{username},#{password},#{useremail},#{regtime},#{ipaddress});")
//    public void insertUser(User user);
//
//
//    @Update(value = "update tb_user set password=#{newPassword} where userid = #{id}")
//    public void updatePassword(@Param("id") int id, @Param("newPassword") String newPassword);




//    @Select("select * from tb_user")
//    @Results({
//            @Result(id = true,column = "id", property ="id"),
//            @Result(column = "username", property ="username"),
//            @Result(column = "password", property ="password"),
//            @Result(
//                    property = "orders" ,
//                    column = "id",
//                    javaType = List.class,
//                    many = @Many(select = "com.zhy.mapper.OrderMapper.findByUid")
//            )
//    })
//    public List<User> findUserAndOrderAll();


}
