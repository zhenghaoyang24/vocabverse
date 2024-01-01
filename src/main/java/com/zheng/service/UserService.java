package com.zheng.service;

import com.zheng.pojo.User;

public interface UserService {

    User findUserByNameAndEmail(String usereemail, String userpassword);

    void userSignUp(User user);

    User findUserById(int userid);

    User findUserByEmail(String useremail);



}
