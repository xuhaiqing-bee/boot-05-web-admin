package com.atguigu.admin.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author xuhaiqing
 * @version 1.0
 * @Description     编写拦截器
 * @date 2023/4/5 0005 17:48
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截的请求是：" + requestURI);

        //登陆检查
        HttpSession session = request.getSession();
        Object user = session.getAttribute("loginUser");

        if (user != null){
            return true;
        }

        //拦截住，未登录，跳转到登录页
        request.setAttribute("msg","请先登录");
        request.getRequestDispatcher("/").forward(request,response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            log.info("postHandle方法执行:" + modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            log.info("afterCompletion方法执行，异常：" + ex);
    }
}
