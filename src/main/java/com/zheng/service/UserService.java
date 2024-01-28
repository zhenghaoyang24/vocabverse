package com.zheng.service;

import com.zheng.pojo.User;

public interface UserService {

    User findUserByNameAndEmail(String usereemail, String userpassword);

    void userSignUp(User user);

    User findUserById(int userid);

    User findUserByEmail(String useremail);

    /*修改用户个人信息*/
    boolean updateUserDataService(String newValue,String category,int userid);



}
