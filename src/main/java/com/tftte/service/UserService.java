package com.tftte.service;

import com.tftte.bean.UserInfo;

/**
 * @Author: tftte
 * @Date: 2020/8/1 22:20
 * @Description: service层
 */
public interface UserService {

    /**
     * 根据用户名和密码进行用户登录
     * @param userInfo
     * @return
     */
    UserInfo findByAccount(UserInfo userInfo);
}
