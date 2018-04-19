package com.zlt.liao.tongauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: zhoulitong
 * @date: 2018/4/17
 * @description: 继承了资源管理拦截器，对请求的url拦截，实现了拦截器，对登录重写了登录拦截器，依托了UrlAccessDecisionManager(AccessDecisionManager)这些组件
 */
@Service
public class UrlFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {
    /**
     * 访问url时，会通过AbstractSecurityInterceptor拦截器拦截，其中会调用FilterInvocationSecurityMetadataSource的方法来获取被拦截url所需的全部权限
     */
    @Autowired
    private FilterInvocationSecurityMetadataSource securityMetadataSource;

    /**
     * 根据类型自动装配（注入）
     * @param urlAccessDecisionManager
     */
    @Autowired
    public void setUrlAccessDecisionManager(UrlAccessDecisionManager urlAccessDecisionManager) {
        super.setAccessDecisionManager(urlAccessDecisionManager);
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //获取拦截到的请求响应信息
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        invoke(fi);
    }


    public void invoke(FilterInvocation fi) throws IOException, ServletException {
        //**********************************************一些内部实现逻辑，仅供参考*************************
        //前提：fi里面有一个被拦截的url
        //1、是否为null;
        //2、合法性
        //3、将fi.getrequest通过UrlMetadataSourceService中重写的getAttributes方法将传过来的object也就是fi的请求，重新初始化到ConfigAttribute类中
        //4、判断attributes是否为空
        //5、判断SecurityContextHolder.getContext().getAuthentication()是否为空
        //6、否则请求authenticateIfRequired方法，判断该请求是否为必须授权才能用的，如果是授权才能用的则调用AuthenticationManager的authenticate方法，然后将用户信息存入到SecurityContextHolder.getContext()中
        //7、调用UrlAccessDecisionManager的decide方法判断是否为匿名方法，若不是匿名方法则对authentication中的url和当前请求匹配查看是否有权限
        //8、返回token中携带了security context、fi、UrlMetadataSourceService中重写的getAttributes方法返回值
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            //执行下一个拦截器
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }
    @Override
    public void destroy() {

    }
    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;

    }

    /**
     * 在此作用域中调用实现了SecurityMetadataSource的FilterInvocationSecurityMetadataSource
     * @return
     */
    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }
}
