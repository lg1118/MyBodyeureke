package com.czxy.fifter;

import com.czxy.domain.User;
import com.czxy.utils.JwtUtils;
import com.czxy.utils.RasUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFefter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        //1 获得工具类(请求上下文对象)
        RequestContext requestContext = RequestContext.getCurrentContext();
        //2 通过工具类获得request对象
        HttpServletRequest request = requestContext.getRequest();

        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        if("/api/userservice/user/login".equals(requestURI)||"/api/userservice/user/registered".equals(requestURI)){
            return false;
        }

        return true;           //3 是否执行
    }
    private static final String pubKeyPath = "D:\\ras\\ras.pub";
    @Override
    public Object run() throws ZuulException {
        //1 获得工具类（请求上下文）
        RequestContext requestContext = RequestContext.getCurrentContext();
        //2 获得请求对象
        HttpServletRequest request= requestContext.getRequest();
        //3 获得请求头 ，获得token值
        String token = request.getHeader("authorization");
        //4 判断 -- 校验
        try {
            JwtUtils.getObjectFromToken(token, RasUtils.getPublicKey(pubKeyPath),User.class);
        } catch (Exception e) {
            e.printStackTrace();
            //不允许放行
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(403);
        }

        //放行
        return null;
    }
}
