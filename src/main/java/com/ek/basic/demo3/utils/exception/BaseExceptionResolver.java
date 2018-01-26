package com.ek.basic.demo3.utils.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: BaseExceptionResolver
 * @Description: 全局异常处理器 要在springmvc.xml中配置 在deleteItems() 方法里测了 
 * @author: ek
 * @date: 2017年9月15日 下午11:54:36
 */
public class BaseExceptionResolver implements HandlerExceptionResolver {

  /**
   * @Title: resolveException
   * @Description:
   * @param request
   * @param response
   * @param handler 就是处理器适配器要执行的Handler对象
   * @param ex 系统抛出的异常
   */
  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    // 解析出异常类型
    // 如果异常类型是自定义异常,直接去出异常信息,在错误页面展示
    // 如果不是自定义异常(通常是运行时异常),构建一个自定义异常类型(信息为未知错误)
    
    // String message = null;
    // if(ex instanceof CustomException){
    // message = ((CustomException)ex).getMessage();
    // }else{
    // message = "位置错误";
    // }
    
    //上面的代码变为:
    CustomException customException = null;
    if(ex instanceof CustomException){
      customException = (CustomException)ex;
    }else{
      customException = new CustomException("未知错误");
    }
    String message = customException.getMessage();
    
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("message", message);
    modelAndView.setViewName("/demo3/error");
    return modelAndView;
  }

}