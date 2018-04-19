package com.zlt.liao.tongauth.dao;

import com.zlt.liao.tongauth.entity.domain.Permission;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author: zhoulitong
 * @date: 2018/4/17
 * @description: 资源Dao
 */
@Component
public interface PermissionDao {

    List<Permission> getByMap(Map<String, Object> map);

    Permission getById(Integer id);

    Integer create(Permission permission);

    int update(Permission permission);

    List<Permission> getByUserId(Integer userId);
}
