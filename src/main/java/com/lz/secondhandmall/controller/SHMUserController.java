package com.lz.secondhandmall.controller;

import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.log.SWordLogger;
import com.lz.secondhandmall.bean.User;
import com.lz.secondhandmall.service.SHMUserService;
import com.lz.secondhandmall.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description: 用户接口
 * @Author: lz
 * @Since: 2019/12/18 15:24
 * @History 2019/12/18 created by lz
 */
@RequestMapping(value = "/shm/user")
@RestController
public class SHMUserController {

    @Autowired
    SHMUserService userService;

    @Autowired
    private SWordLogger logger;

    /**
     * 用户登录
     * @param user 前端传给后台一个user对象
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody User user) {
        System.out.println(user);
        user = this.userService.login(user);
        return Response.ok().data(user);
    }

    /**
     * 用户注册
     * @param user 页面传给后台一个user对象
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response register(@RequestBody User user) {
        this.logger.debug("user : " + user);
        if (this.userService.register(user)) {
            return Response.ok();
        } else {
            return Response.error("该手机号已被注册");
        }
    }

    /**
     * 查询所有用户
     * @return 用户集合
     */
    @RequestMapping(value = "/findAllUser", method = RequestMethod.POST)
    public Response findAllUser() {
        return Response.ok().data(this.userService.findAllUser());
    }

    /**
     * 根据UserId查询用户
     * @param user user对象
     * @return
     */
    @RequestMapping(value = "/findUserById", method = RequestMethod.POST)
    public Response findUserById(User user) {
        return Response.ok().data(this.userService.findUserById(user));
    }

    /**
     * 根据用户id修改用户信息
     * @param user user对象
     * @return
     */
    @RequestMapping(value = "/modifyUserInfoById", method = RequestMethod.POST)
    public Response modifyUserInfoById(@RequestBody User user) {
        this.logger.debug("user : " + user);
        this.userService.modifyUserInfoById(user);
        return Response.ok();
    }

    /**
     * 获取验证码
     * @param phone 手机号
     * @return
     */
    @RequestMapping(value="/sendMessage", method = RequestMethod.POST)
    public int sendMessage(HttpServletRequest request, @RequestBody String phone) {

        long l = System.currentTimeMillis();
        int code = (int) (l % 1000000);
        String toPhoneCode = String.valueOf(code);

        // session中保存如上生成的验证码，为了将来拿出来与用户提交的进行比较
//        Subject subject = SecurityUtils.getSubject();
//        Session session = subject.getSession();
//        session.setAttribute("toPhoneCode", toPhoneCode);

        HttpSession session = request.getSession();
        session.setAttribute("toPhoneCode", toPhoneCode);

        System.out.println(phone);
        // 成功返回1，失败返回0
        if (null != phone) {
            SmsUtils.sendMessage(phone, toPhoneCode);
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 比较验证码
     * @param inputCode 页面输入的验证码
     * @return
     */
    @RequestMapping(value = "/compareCode", method = RequestMethod.POST)
    public int compareVerificationCode(HttpServletRequest request, @RequestBody String inputCode) {

//        Subject subject = SecurityUtils.getSubject();
//        Session session = subject.getSession();
//        String toPhoneCode = (String) session.getAttribute("toPhoneCode");
        HttpSession session = request.getSession();
        String toPhoneCode = (String)session.getAttribute("toPhoneCode");

        // 验证码不为空时，到后台进行比较，返回响应码
        // 响应码为1时，提示请先获得验证码
        // 响应码为2时，提示验证码错误
        // 响应码为3时，验证码正确，提示验证码正确
        if (null == toPhoneCode) {
            return 1;
        } else if (toPhoneCode.equals(inputCode)) {
            return 3;
        } else {
            return 2;
        }

    }

}
