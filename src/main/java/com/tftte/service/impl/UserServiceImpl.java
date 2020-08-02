package com.tftte.service.impl;

import com.tftte.bean.UserInfo;
import com.tftte.mapper.UserMapper;
import com.tftte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: tftte
 * @Date: 2020/8/1 22:26
 * @Description:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名和密码进行用户登录
     * @param userInfo
     * @return
     */
    @Override
    public UserInfo findByAccount(UserInfo userInfo) {
        return userMapper.findByAccount(userInfo);
    }
}
