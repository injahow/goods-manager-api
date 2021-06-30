package com.injahow.booksManager.utils.handler;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@Configuration
/*class MyConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
}*/
/*
public class MyInterceptor implements HandlerInterceptor { // 配置spring-mvc自定义拦截器，需要配置xml

    // 预处理
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //System.out.println("预处理");
        // 判断请求
        // return 表示是否放行
        return true;
    }
    // 后处理，根据需求写
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //System.out.println("后处理");
        //
    }
}
*/


