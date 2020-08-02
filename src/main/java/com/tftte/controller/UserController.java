package com.tftte.controller;

import com.tftte.bean.UserInfo;
import com.tftte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: tftte
 * @Date: 2020/8/1 22:35
 * @Description: controller层
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 后台登录
     * @param userInfo: 封装前台请求的数据，表单name中的值跟user重的属性一致
     * @param model: 将后台数据传递给前台
     * @param session: 传统的session
     * @return
     */
    @RequestMapping("/login")
    public String login(UserInfo userInfo, Model model, HttpSession session) {
        UserInfo user = userService.findByAccount(userInfo);
        if (user == null) {
            // 账号不正确
            model.addAttribute("msg", "账号或密码错误!");
            return "login";
        }

        // 登录成功，将当前用户的信息保存在session中
        session.setAttribute("loginUser", user);
        return "main";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "epidemic";
    }
}
