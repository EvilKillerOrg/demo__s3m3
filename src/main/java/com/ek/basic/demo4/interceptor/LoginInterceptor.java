package com.ek.basic.demo4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: LoginInterceptor
 * @Description: HandlerInterceptor1 HandlerInterceptor2
 *               只是拦截器的执行顺序演示,这里是login的实际拦截器
 * @author: ek
 * @date: 2017年10月10日 上午1:56:50
 */
public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    // 先要取到url判断是不是公开地址不拦截(实际中 公开地址要配置的配置文件中)
    String url = request.getRequestURI();
    if (url.indexOf("login.do") >= 0) { // 如果是登录提交放行
      return true;
    }

    // 判断用户session 是否存在 不存在跳转到登录页面,存在放行
    HttpSession session = request.getSession();
    String username = (String) session.getAttribute("username");
    if (username != null && !"".equals(username)) { // 用户信息存在放行
      return true;
    }
    
    // 执行到这里就说明需要用户登录
    request.getRequestDispatcher("/WEB-INF/jsp/demo4/login.jsp").forward(request, response);
    
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

  }

}