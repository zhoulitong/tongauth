package com.zlt.liao.tongauth.security;

import com.zlt.liao.tongauth.dao.PermissionDao;
import com.zlt.liao.tongauth.dao.UserDao;
import com.zlt.liao.tongauth.entity.domain.Permission;
import com.zlt.liao.tongauth.entity.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhoulitong
 * @date: 2018/4/17
 * @description: 根据当前用户名称查询数据库用户权限数据
 */
@Service
public class UrlAuthUserService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Autowired
    PermissionDao permissionDao;

    /**
     * 重写loadUserByUsername 方法获得 userdetails 类型用户
     * @param userName 用户名称
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName){
        User user = userDao.getByUserName(userName);
        if (user != null) {
            List<Permission> permissions = permissionDao.getByUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName() != null) {
                    GrantedAuthority grantedAuthority = new UrlGrantedAuthority(permission.getPermissionUrl(), permission.getMethod());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            user.setGrantedAuthorities(grantedAuthorities);
            return user;
        } else {
            throw new UsernameNotFoundException("admin: " + userName + " do not exist!");
        }
    }
}
