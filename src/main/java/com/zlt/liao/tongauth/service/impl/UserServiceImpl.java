package com.zlt.liao.tongauth.service.impl;

import com.zlt.liao.tongauth.dao.UserDao;
import com.zlt.liao.tongauth.entity.domain.User;
import com.zlt.liao.tongauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhoulitong
 * @date: 2018/4/17
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(Integer id) {
        User user = userDao.getById(id);
        return user;
    }
}
