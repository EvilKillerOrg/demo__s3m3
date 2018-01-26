package com.ek.basic.demo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ek.basic.demo3.model.vo.ItemsCustomVO;
import com.ek.basic.demo3.service.IItemsService;

/**
 * @ClassName: RESTfulController
 * @Description: 测试RESTful风格 (只用到了url模板映射)
 * @author: ek
 * @date: 2017年9月19日 上午2:01:39
 */
@Controller
@RequestMapping("/rest")
public class RESTfulController {
  
  @Autowired
  private IItemsService itemsService;

  /* 输出json (没有页面的) */
  /* 这种访问的时候需要再多配一个前端控制器的url-pattern是 / 要不然就不是RESTful风格了
   * 但是这样带来一个问题就是所有请求的url都会被springmvc的处理器映射器捕获,但是访问静态资源的时候就会找不到Handler 
   * 所以 springmvc 提供了一种方式访问静态资源的方式: 在springmvc.xml中配置静态资源访问解析 */
  @RequestMapping("/itemsView/{item_id}") //url模板映射
  public @ResponseBody ItemsCustomVO itemsView(@PathVariable("item_id") Integer id) throws Exception{
    ItemsCustomVO itemsCustomVO = itemsService.findItemsById(id);
    return itemsCustomVO;
  }

}