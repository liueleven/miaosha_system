package com.imooc.miaosha.service;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-14 22:39
 * @author: 十一
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User findById(Integer id) {
       return userDao.findById(id);
    }
}
