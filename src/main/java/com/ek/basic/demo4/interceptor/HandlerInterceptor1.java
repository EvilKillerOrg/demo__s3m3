package com.ek.basic.demo4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 拦截器都是基于aop切面的
 * @ClassName: HandlerInterceptor1
 * @Description: 拦截器 测试
 * @author: ek
 * @date: 2017年10月10日 上午12:22:57
 */
public class HandlerInterceptor1 implements HandlerInterceptor{

  /*执行的时机:进入Handler方法之前执行这个方法*/
  /*应用场景: 
   * 比如用于身份认证和身份授权.
   * 身份认证:如果认证不通过(即session不存在)就表示当前用户没有登录,需要此方法拦截不再向下执行
   * */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("第一个拦截器...的preHandle()方法");
    //return false; 就表示拦截住,不向下执行
    //return true; 就表示放行
    return true;
  }

  
  
  /*执行的时机:进入Handler方法之后,返回ModelAndView之前执行这个方法*/
  /*应用场景: (从ModelAndView的角度出发)
   * 将一些公用的模型数据在这里传到视图,也可以在这里统一指定视图
   * 比如:菜单数据
   * */
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    System.out.println("第一个拦截器...的postHandle()方法");
  }

  
  
  /*执行的时机:Handler方法执行完成是执行这个方法*/
  /*应用场景:
   * 统一的异常处理,统一的日志处理
   * */
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    System.out.println("第一个拦截器...的afterCompletion()方法");
  }

}