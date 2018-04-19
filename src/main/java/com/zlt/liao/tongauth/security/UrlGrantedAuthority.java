package com.zlt.liao.tongauth.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author: zhoulitong
 * @date: 2018/4/17
 * @description: 构造带有URL和method类型的构造方法
*/
public class UrlGrantedAuthority implements GrantedAuthority {
    private String permissionUrl;
    private String method;

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public UrlGrantedAuthority (String permissionUrl, String method) {
        this.permissionUrl = permissionUrl;
        this.method = method;
    }

    @Override
    public String getAuthority() {
        return this.permissionUrl + ";"+this.method;
    }
}
