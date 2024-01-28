package zhy.testmapper;

import com.zheng.mapper.UserMapper;
import com.zheng.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestUserMapper {
    private UserMapper mapper;

    //抽取
    @Before
    public void before() throws IOException {
        //加载核心文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//true 自动提交事务
        mapper = sqlSession.getMapper(UserMapper.class);
    }


    @Test
    public void findUserById() {
        User user = mapper.findUserByIdMapper(1);
        System.out.println(user);
    }

    @Test
    public void findUserByUserEmailMapper() {
        User user = mapper.findUserByUserEmailMapper("12@qq.c2om");
        System.out.println(user);
    }

    @Test
    public void findUserByNameAndEmail() {
        User user = mapper.findUserByNameAndEmail("zhenghaoyang24@foxmail.com", "81cb439337d498c9ed8178625209c65b");
        System.out.println(user);
    }



    @Test
    public void userSignUp() {
        User user = new User();
        user.setUserid(435125);
        user.setNickname("zhy121");
        user.setUseremail("1ddd32q@qq.c2om");
        user.setUserpassword("12223");
        user.setRegtime("2023-12-12");
        System.out.println(user);
        mapper.userSignUpMapper(user);
    }

    @Test
    public void updateUser1() {
        mapper.updateGenderMapper("1",1000);

    }





}
