package com.zlt.liao.tongauth.security;

import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhoulitong
 * @date: 2018/4/17
 * @description: UrlConfigAttribute 类初始化的时候初始化HttpServletRequest
 */
public class UrlConfigAttribute implements ConfigAttribute {
    private final HttpServletRequest httpServletRequest;

    public UrlConfigAttribute(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }
    @Override
    public String getAttribute() {
        return null;
    }
    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }
}
