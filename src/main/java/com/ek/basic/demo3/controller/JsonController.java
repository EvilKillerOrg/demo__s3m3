package com.ek.basic.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ek.basic.demo3.model.pojo.ItemsPOJO;
/**
 * @ClassName: JsonController
 * @Description: Json测试(应该配置适配器,但是用了高大上的annotation-driven 有这个标签有够了)
 * @author: ek
 * @date: 2017年9月18日 下午7:04:43
 */
@Controller
@RequestMapping("/json")
public class JsonController {

  @RequestMapping("/testPage")
  public String showJsonTestPage(){
   
    return "/json/jsonTest";
  }
  
  
  /* 请求是json串(商品信息),输出json(商品信息) */
  //@RequestBody 将请求的商品信息的json串转成ItemsPOJO对象
  //@ResponseBody ItemsPOJO转成json输出
  @RequestMapping("/requestJson")
  public @ResponseBody ItemsPOJO requestJson(@RequestBody ItemsPOJO itemsPOJO){
    
    return itemsPOJO;
  }
  
  
  /* 请求是key/value,输出是json */
  //@ResponseBody ItemsPOJO转成json输出
  @RequestMapping("/responseJson")
  public @ResponseBody ItemsPOJO responseJson(ItemsPOJO itemsPOJO){
    
    return itemsPOJO;
  }
}