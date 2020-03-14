package com.lz.secondhandmall.dao;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.mpaas.log.SWordLogger;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.lz.secondhandmall.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @Author: lz
 * @Since: 2019/12/18 15:27
 * @History 2019/12/18 created by lz
 */
@Repository("user")
public class SHMUserDao {

    @Autowired
    private MpaasQueryFactory sw;

    @Autowired
    private SWordLogger logger;

    /**
     * 用户登录
     * @param user 页面传过来的user对象
     * @return
     */
    public User login(User user) {
        if (null == user.getUserPhone()) {

            User users = sw.buildQuery()
                    .eq("userName", user.getUserName())
                    .eq("userPassword", user.getUserPassword())
                    .doQueryFirst(User.class);

            if (null == users) {
                throw new MpaasBusinessException("用户名不存在或密码错误");
            }
            return users;

        } else {
            User users = sw.buildQuery()
                    .eq("userPhone", user.getUserPhone())
                    .doQueryFirst(User.class);

            if (null == users) {
                throw new MpaasBusinessException("该手机号码未注册");
            }
            return users;
        }
    }

    /**
     * 用户注册
     * @param user 页面传过来的user对象
     * @return
     */
    public boolean register(User user) {
        System.out.println(user);
        if (null == user.getUserPhone()) {
            throw new MpaasBusinessException("手机号为空");
        } else {
            List<User> list = this.sw
                    .buildQuery()
                    .eq("userPhone", user.getUserPhone())
                    .doQuery(User.class);

            if (0 == list.size()) {
                this.logger.debug("user : " + user);
                user.setUserRole("normal");
                user.setUserAvatar("C:\\Users\\lz\\Pictures\\Camera Roll");
                user.setCreationDate(new Date());
                this.sw
                        .buildQuery()
                        .doInsert(user);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 查询所有用户
     * @return 用户集合
     */
    public List<User> findAllUser() {
        return sw.buildQuery()
                .unSelect("userPassword")
                .doQuery(User.class);
    }

    /**
     * 根据userId查询用户
     * @param user user对象
     * @return 用户集合
     */
    public List<User> findUserById(User user) {
        return sw.buildQuery()
                .eq("userId", user.getUserId())
                .doQuery(User.class);
    }

    /**
     * 根据用户id修改用户信息
     * @param user 页面传过来的user对象
     */
    public void modifyUserInfoById(User user) {
        this.logger.debug("user : " + user);
        this.sw
                .buildQuery()
                .eq("userId", user.getUserId())
                .doUpdate(user);
    }

}
