package com.ek.basic.demo4.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: LoginController
 * @Description: 登陆Controller 使用连接器实现 需求是首页等公共页面url不拦截,没有session的跳到登陆页面
 * @author: ek
 * @date: 2017年10月10日 上午1:24:37
 */

@Controller
public class LoginController {
  
  
  @RequestMapping("/index")
  public String index() throws Exception{
    return "/demo4/login";
  }
  
  /* 登陆 */
  @RequestMapping("/login")
  public String login(HttpSession session, String username, String password) throws Exception {
    // 调用service进行用户身份验证
    // ...

    // 在session中保存用户身份信息
    session.setAttribute("username", username);

    // 重定向(这里重定向没成,redirect 不能直接redirect到web-info下的jsp,当然到是可以重定向到controller的方法)
    return "/demo4/success";
  }
  
  
  

  /* 退出 */
  @RequestMapping("/logout")
  public String logout(HttpSession session) throws Exception {
    //清session
    session.invalidate(); //session 过期
    
    
    return "redirect:/index.jsp";
  }
}