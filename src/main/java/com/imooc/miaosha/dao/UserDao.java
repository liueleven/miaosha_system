package com.imooc.miaosha.dao;

import com.imooc.miaosha.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-14 22:37
 * @author: 十一
 */
@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User findById(@Param("id") Integer id);
}
