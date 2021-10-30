package com.abc.hotelsys.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取访问地址
        String uri = request.getRequestURI();

        //对这些网址进行登录控制
        if(uri.contains("/hotelsys5/users")||uri.contains("/hotelsys5/rooms")||uri.contains("/hotelsys5/hotels")){
            HttpSession session = request.getSession();
            Object user = session.getAttribute("loginedUser");
            if(user==null){
                System.out.println("check fail, stop! goto login!");
                response.sendRedirect("/hotelsys5/toLogin");
                return false;
            }
        }

//		 其它网址一律放行
        return true;
    }
}
