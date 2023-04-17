package com.atguigu.admin.config;

import com.atguigu.admin.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xuhaiqing
 * @version 1.0
 * @Description
 * 1* 编写拦截器实现HandlerInterceptor
 * 2* 将拦截器注册到配置类（implements WebMvcConfigurer）
 * 3* 指定拦截规则
 * @date 2023/4/5 0005 17:56
 */
@Configuration
public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new LoginInterceptor())
              .addPathPatterns("/**")    //所有请求被拦截，包括静态资源
              .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");   //放行静态资源
    }
}
