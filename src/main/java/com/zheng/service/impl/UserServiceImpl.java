package com.zheng.service.impl;

import com.zheng.mapper.UserMapper;
import com.zheng.pojo.User;
import com.zheng.service.UserService;
import com.zheng.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();



    @Override
    public User findUserByNameAndEmail(String useremail, String userpassword) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        User userByNameAndEmail = usermapper.findUserByNameAndEmail(useremail, userpassword);
        sqlSession.close();
        return userByNameAndEmail;
    }

    /**
     * 注册
     * @param user
     */
    @Override
    public void userSignUp(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        usermapper.userSignUpMapper(user);
        sqlSession.close();
    }

    @Override
    public User findUserById(int userid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        User userByIdMapper = usermapper.findUserByIdMapper(userid);
        sqlSession.close();
        return userByIdMapper;
    }

    @Override
    public User findUserByEmail(String useremail) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        User userByUserEmailMapper = usermapper.findUserByUserEmailMapper(useremail);
        sqlSession.close();
        return userByUserEmailMapper;
    }


}
