package com.ek.basic.demo2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.ek.basic.demo2.po.UserInfoD2;

/**
 * 这个包中的3个controller 是学习springMVC的三种映射器和适配器的
 * 非注解的Handler2
 * 实现HttpRequestHandler接口 的Handler
 * 
 * @author EK
 * @date 2017年8月29日
 */
public class UserInfoController2 implements HttpRequestHandler {

  @Override
  public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
    List<UserInfoD2> userList = new ArrayList<UserInfoD2>();
    UserInfoD2 user1 = new UserInfoD2();
    user1.setUuid(1);
    user1.setUserName("hhh");
    UserInfoD2 user2 = new UserInfoD2();
    user2.setUuid(2);
    user2.setUserName("eee");
    userList.add(user1);
    userList.add(user2);
    
    request.setAttribute("userList", userList);
    
    request.getRequestDispatcher("/WEB-INF/jsp/demo2/userList.jsp").forward(request, response);
    
    //用实现HttpRequestHandler接口的Handler的好处是可以通过修改response,设置响应的数据格式,比如响应json数据
//    response.setCharacterEncoding("utf-8");
//    response.setContentType("application/json;charset=utf-8");
//    response.getWriter().write("json串");
    
  }

 

}