package com.lz.secondhandmall.service;

import com.definesys.mpaas.log.SWordLogger;
import com.lz.secondhandmall.bean.User;
import com.lz.secondhandmall.dao.SHMUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @Author: lz
 * @Since: 2019/12/18 15:30
 * @History 2019/12/18 created by lz
 */
@Service("userService")
public class SHMUserService {

    @Autowired
    private SWordLogger logger;

    @Autowired
    SHMUserDao userDao;

    public User login(User user) {
        return this.userDao.login(user);
    }

    public boolean register(User user) {
        return this.userDao.register(user);
    }

    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    public List<User> findUserById(User user) {
        return this.userDao.findUserById(user);
    }

    public void modifyUserInfoById(User user) {
        this.userDao.modifyUserInfoById(user);
    }

}
