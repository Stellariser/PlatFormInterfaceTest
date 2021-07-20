package com.kaung.Interceptor;

import com.kaung.Util.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Token拦截器
 * @author : Bei-Zhen
 * @date : 2020-12-26 9:27
 */
public class TokenInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        System.out.println(url);
        if(!url.endsWith("user/login")){
            //从http请求头中取出token
            String token = request.getHeader("Authorization");
            System.out.println(token);
            //执行认证
            if(TokenUtil.verify(token)){
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
