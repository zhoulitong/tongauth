package com.zlt.liao.tongauth.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhoulitong
 * @date: 2018/4/17
 * @description: 调用FilterInvocationSecurityMetadataSource的方法来获取被拦截url所需的全部权限
 */
@Service
public class UrlMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    /**
     * 将传过来的object也就是拦截器拦截的请求，重新初始化到ConfigAttribute类中
     * @param object 拦截器拦截的请求
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        Set<ConfigAttribute> allAttributes = new HashSet<>();
        ConfigAttribute configAttribute = new UrlConfigAttribute(request);
        allAttributes.add(configAttribute);
        return allAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
