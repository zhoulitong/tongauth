package com.zlt.liao.tongauth.dao;

import com.zlt.liao.tongauth.entity.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author: zhoulitong
 * @date: 2018/4/17
 * @description: UserDao
 */
@Component
public interface UserDao {

    List<User> getByMap(Map<String, Object> map);
    List<User> getByRoleId(Map<String, Object> map);
    User getById(Integer id);
    Integer create(User user);
    int update(User user);
    User getByUserName(String userName);
}
