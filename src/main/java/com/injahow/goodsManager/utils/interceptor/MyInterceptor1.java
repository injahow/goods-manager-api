package com.injahow.goodsManager.utils.interceptor;

import com.injahow.goodsManager.utils.AuthUtil;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor1 implements HandlerInterceptor {

    /**
     * 在请求到达Controller控制器之前 通过拦截器执行一段代码
     * 如果方法返回true,继续执行后续操作
     * 如果返回false，执行中断请求处理，请求不会发送到Controller
     */
    public void crossDomain(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "86400");
        response.setHeader("Access-Control-Allow-Headers", "*");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //logger.info("拦截器1 在控制器执行之前执行");
        crossDomain(request, response);

        String token = request.getHeader("X-Token");
        if(token == null || token.equals("")){
            response.getWriter().print("no token");
            return false;
        }else {
            JwtParser parser = Jwts.parser();
            parser.setSigningKey(AuthUtil.SECRET);
            try {
                parser.parseClaimsJws(token);
                return true;
            } catch (Exception e) {
                response.getWriter().print("token error");
                return false;
            }
        }
    }

    /**
     * 跳转之后执行
     */
    /*@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //logger.info("拦截器1 最后执行");
        //System.out.println("after");
    }*/
}