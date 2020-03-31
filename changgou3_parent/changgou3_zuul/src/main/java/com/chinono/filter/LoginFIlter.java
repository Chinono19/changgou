package com.chinono.filter;

import com.chinono.config.FilterProperties;
import com.chinono.config.JwtProperties;
import com.chinono.po.User;
import com.chinono.utils.JwtUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class LoginFIlter extends ZuulFilter {
    @Override
    public String filterType() {
        //设置为请求前拦截
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 5;
    }

    @Resource
    private FilterProperties filterProperties;
    @Override
    public boolean shouldFilter() {
        //如果是白名单上的路径直接放
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String requestURI = request.getRequestURI();
        List<String> allowPaths = filterProperties.getAllowPaths();
        for (String path : allowPaths) {
            if (requestURI.contains(path)){
                //如果是白名单上的路径   不进行拦截
                return false;
            }
        }
        //否则进行拦截
        return true;
    }

    @Resource
    private JwtProperties jwtProperties;
    @Override
    public Object run() throws ZuulException {
        //1) 重请求头中获得token
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getHeader("Authorization");
        try {
            JwtUtils.getObjectFromToken(token,jwtProperties.getPublicKey(), User.class);
        } catch (Exception e) {
            e.printStackTrace();
            //提示信息
            currentContext.addOriginResponseHeader("content-type","text/html;charset=UTF-8");
            currentContext.addZuulRequestHeader("content-type","text/html;charset=UTF-8");
            currentContext.setResponseBody("token无效或失效");
            // 2) 403 状态码
            currentContext.setResponseStatusCode(403);
            currentContext.setSendZuulResponse(false);
        }
        return null;
    }
}
