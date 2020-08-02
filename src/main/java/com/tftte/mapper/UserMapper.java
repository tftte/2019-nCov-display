package com.tftte.mapper;

import com.tftte.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: tftte
 * @Date: 2020/8/1 22:03
 * @Description: dao层，对数据库进行增删改查
 */
@Mapper
public interface UserMapper {
    @Select(value = "SELECT u.user_id, u.account, u.`password`, u.user_name FROM users u " +
            " WHERE u.account = #{account} AND u.`password` = #{password} AND u.del_flag = 0;")
    UserInfo findByAccount(UserInfo userInfo);
}
