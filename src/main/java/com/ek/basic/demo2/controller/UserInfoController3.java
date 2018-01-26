package com.ek.basic.demo2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ek.basic.demo2.po.UserInfoD2;

/**
 * 这个包中的3个controller 是学习springMVC的三种映射器和适配器的
 * 注解的Handler
 * 可以在IoC配置加载这个bean
 * 一个个配太麻烦,可以用context:component-scan 直接扫描加载
 * context:component-scan 可以扫描到@Controller,@Service,@Repository等标识的组件
 * 
 * @author EK
 * @date 2017年8月29日
 */

@Controller //@Controller标识这是一个控制器
public class UserInfoController3 {

  @RequestMapping("/queryUsers3") //映射url和方法可以加.do也可以不加
  public ModelAndView queryItems() throws Exception {
    
    List<UserInfoD2> userList = new ArrayList<UserInfoD2>();
    UserInfoD2 user1 = new UserInfoD2();
    user1.setUuid(1);
    user1.setUserName("hhh");
    UserInfoD2 user2 = new UserInfoD2();
    user2.setUuid(2);
    user2.setUserName("eee");
    userList.add(user1);
    userList.add(user2);

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("userList",userList);
//  modelAndView.setViewName("/WEB-INF/jsp/demo2/userList.jsp");
    modelAndView.setViewName("/demo2/userList"); //设置前后缀上面那种就用不成了
    return modelAndView;
  }

}