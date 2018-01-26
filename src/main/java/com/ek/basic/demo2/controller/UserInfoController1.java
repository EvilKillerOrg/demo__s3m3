package com.ek.basic.demo2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ek.basic.demo2.po.UserInfoD2;

/**
 * 这个包中的3个controller 是学习springMVC的三种映射器和适配器的
 * 非注解的Handler1
 * 实现Controller接口 的Handler
 * 
 * @author EK
 * @date 2017年8月29日
 */
public class UserInfoController1 implements Controller {

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<UserInfoD2> userList = new ArrayList<UserInfoD2>();
    UserInfoD2 user1 = new UserInfoD2();
    user1.setUuid(1);
    user1.setUserName("hhh");
    UserInfoD2 user2 = new UserInfoD2();
    user2.setUuid(2);
    user2.setUserName("eee");
    userList.add(user1);
    userList.add(user2);
    
    
    // 返回ModelAndView
    ModelAndView modelAndView = new ModelAndView();
    // addObject()相当于 request.setAttribute(arg0, arg1);
    modelAndView.addObject("userList", userList);
    // 指定视图
//  modelAndView.setViewName("/WEB-INF/jsp/demo2/userList.jsp");
    modelAndView.setViewName("/demo2/userList"); //设置前后缀上面那种就用不成了
    return modelAndView;
  }

}