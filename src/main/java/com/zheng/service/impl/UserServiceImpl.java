package com.zheng.service.impl;

import com.zheng.mapper.UserMapper;
import com.zheng.pojo.User;
import com.zheng.service.UserService;
import com.zheng.utils.SendMailCodeUtil;
import com.zheng.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.Random;


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

    @Override
    public boolean updateUserDataService(String newValue, String category, int userid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        if (category.equals("avatar")) {
            return mapper.updateAvatarMapper(newValue, userid);
        }
        if (category.equals("synopsis")) {
            return mapper.updateSynopsisMapper(newValue, userid);
        }
        if (category.equals("nickname")) {
            return mapper.updateNicknameMapper(newValue, userid);
        }
        if (category.equals("gender")) {
            return mapper.updateGenderMapper(newValue, userid);
        }
        if (category.equals("birthday")) {
            return mapper.updateBirthdayMapper(newValue, userid);
        }
        if (category.equals("phonenumber")) {
            return mapper.updatePhonenumberMapper(newValue, userid);
        }
        if (category.equals("school")) {
            return mapper.updateSchoolMapper(newValue, userid);
        }
        if (category.equals("region")) {
            return mapper.updateRegionMapper(newValue, userid);
        }
        sqlSession.close();
        return false;
    }

    @Override
    public boolean updatePasswordService(String userpassword, int userid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        boolean b = usermapper.updatePasswordMapper(userpassword, userid);
        sqlSession.close();
        return b;
    }


}
