package com.ek.basic.demo3.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ek.basic.demo3.model.pojo.ItemsPOJO;
import com.ek.basic.demo3.model.vo.ItemsCustomVO;
import com.ek.basic.demo3.service.IItemsService;
import com.ek.basic.demo3.utils.exception.CustomException;
import com.ek.basic.demo3.utils.validation.ValidGroup2;
/**
 * 商品信息controller
 * @ClassName: ItemsController
 * @Description: 管理商品信息url
 * @author: ek
 * @date: 2017年9月10日 上午1:45:04
 */


/* @RequestMapping的作用
 * 1.声明url 2.窄化请求映射 3.限制http请求方式
 */

/* Controller的返回值
 * 1.ModelAndView 2.String(逻辑视图名,重定向,请求转发) 3.void
 */ 

/* Springmvc数据绑定 通过方法形参来接收(说的是request传参怎么接收)
 * 形参可以定义 Model request response等 还可以直接定义简单类型
 * 接收到的实际上就是一个request 看源码model的键值就在request里 
 * 
 * 绑定简单类型(详见findItemsById方法),可以用@RequestParam进行参数绑定 或者request传入参数名和方法形参名一致也可以取到
 * 绑定对象类型(详见updateItems方法),页面上input的name 和 controller的对象形参的属性名一致就可以绑定(类中包装类再点一层)
 * 自定义参数绑定看配置文件吧(springmvc.xml)
 * 集合list map通常用在批量提交数据(集合可以定义在包装对象中,如:ItemsCustomVO,updateBatchItems方法)\数组类型参数绑定(deleteItems方法)
 */
@Controller
@RequestMapping("/item")//添加一个窄化请求映射(相当于给url访问路径加上名称空间)
public class ItemsController {
  
  @Autowired 
  private IItemsService itemsService;
  
  
  
  /**
   * @Title: findItemsList
   * @Description: 查询商品列表
   * @throws Exception
   * @return: ModelAndView
   */
  @RequestMapping("/findItemsList") //给了一个访问这个方法的url连接(注意访问的时候前面还要加上窄化请求映射地址即:/item/queryItems.do)
  public ModelAndView findItemsList(ItemsCustomVO itemsCustomVO) throws Exception{ 
    
    List<ItemsPOJO> itemsList = itemsService.findItemsList(itemsCustomVO);
    
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("itemsList",itemsList);
    modelAndView.addObject("itemsCustomVO",itemsCustomVO); //回显查询条件
    modelAndView.setViewName("/demo3/itemsList");
    return modelAndView ;
  }
  
  
  
  
  
  /**
   * @Title: findItemsById
   * @Description: 根据ID查询一个商品信息,跳转到修改商品信息页面
   * @throws Exception
   * @return: /demo3/itemEdit
   */
  @RequestMapping("/findItemsById")
  //简单类型可以直接传和request传递的参数名称一致的形参进来就行 findItemsById(Model model, Integer id)
  //用@RequestParam绑定形参和request传递的参数(value=request传递的参数名,required可以要求必须要这个参数,defaultValue可以设置默认值(默认值是没有id的时候取默认值))
  public String findItemsById(Model model, @RequestParam(value="id",required=true) Integer item_id) throws Exception{
    
    ItemsCustomVO itemsCustomVO = itemsService.findItemsById(item_id);
    model.addAttribute("itemsCustomVO", itemsCustomVO); //相当于modelAndView.addObject(attributeName, attributeValue)
     
    return "/demo3/itemsEdit" ; //返回一个逻辑视图名,通过形参中的Model携带数据
  }
  
  
  
  
  
  /**
   * @Title: updateItems
   * @Description: 提交修改商品信息
   * @throws Exception
   * @return: forward:findItemsList.do
   */
  /* *
   * 在需要校验的pojo前面要加@Validated,后面要加BindingResult bindingResult接收效验的错误信息
   * 多个pojo需要校验时@Validated和BindingResult 是配对出现的(每个pojo前后都要加)
   * */
  /* *
   * 页面上itemsPOJO里面有个日期类型的createTime 从页面上取过来是字符串
   * 需要配置一下自定义参数绑定也就是类型转换 字符串转换到date类型
   * 看配置文件吧(springmvc.xml)
   * */
  // 校验教程上这里讲的从页面过来的是pojo 但是我页面过来的是vo,效验vo不起作用,在vo中的pojo属性上加了@Valid就好了
  // 检验分组 看validation包中的内容@Validated(value=ValidGroup1.class)制定了使用哪个分组
  // MultipartFile是接收上传文件的 multipartFile_pic这个名字和页面上的文件域name属性要一直
  @RequestMapping(value="/updateItems",method={RequestMethod.POST,RequestMethod.GET})//限制http请求方法为post或get
  public String updateItems(@RequestParam(value="itemsPOJO.id",required=true) Integer id, 
      @Validated(value=ValidGroup2.class)ItemsCustomVO itemsCustomVO, BindingResult bindingResult, Model model, 
      MultipartFile multipartFile_pic) throws Exception{ 
    
    /* 效验 */
    //获取校验错误信息
    if(bindingResult.hasErrors()){
      //输出错误信息
      List<ObjectError> allErrors = bindingResult.getAllErrors();
      //把错误信息传到页面
      model.addAttribute("allErrors", allErrors);
     
     //错误信息打印到后台
      for (ObjectError objectError : allErrors) {
        System.out.println(objectError.getDefaultMessage());
      }
       return "/demo3/itemsEdit"; //出错重新到商品修改页面
    }
    
   
    /* 上传图片 */
    //上传的图片的原始名称
    String originalFilename = multipartFile_pic.getOriginalFilename();
    //判断获得的文件对象和文件名不为空(没有上传新图片就为空了)
    if(multipartFile_pic!=null && originalFilename!=null && originalFilename.length()>0){
      //存储图片的物理路径
      String pic_path="E:\\Environment\\eclipse\\workspace4.5\\pic\\s3m3\\";
     
      //新的图片名称(避免重名)
      String newFinlename = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
      //新的图片对象
      File newFile = new File(pic_path+newFinlename);
      //写入磁盘
      multipartFile_pic.transferTo(newFile);
      //上传成功要把新的文件名写到表中
      itemsCustomVO.getItemsPOJO().setPic(newFinlename);
    } 
    
    /* 提交修改 */
    itemsService.updateItems(id, itemsCustomVO);
   
    /* 跳转 */
    //转向和本方法在同一个controller类中的方法,@RequestMapping的url不用加根路径/item
    return "forward:findItemsList.do"; //请求转发
    //return "redirect:findItemsList.do"; //重定向 
  }
  
 
  
  
  
  /**
   * @Title: deleteItems
   * @Description: 批量删除
   * @param item_id
   * @throws Exception
   * @return: String
   */
  @RequestMapping("/deleteItems")
  public String deleteItems(Integer[] item_id) throws Exception{//页面上批量删除的checkbox标签的name=item_id
    
    //..
    
    if(item_id == null){
      //这里手动抛异常了 就是自定义异常信息, 没有手动抛的话全局异常处理器会构建一个自定义异常 输出未知错误信息
      //这用 try catch 应该也可以吧?
      throw new CustomException("没有选择任何一条信息!");
    }else{
      for (Integer id : item_id) {
        System.out.println(id);
      }
    }
 
    return "forward:findItemsList.do";
  }
  
  
  
  
  
  /**
   * @Title: showBatchItems
   * @Description: 显示批量修改
   * @param itemsCustomVO
   * @throws Exception
   * @return: String
   */
  @RequestMapping("/showBatchItems")
  public String showBatchItems(Model model) throws Exception{
    List<ItemsPOJO> itemsList = itemsService.findItemsList(null);
    model.addAttribute("itemsList", itemsList);
    return "/demo3/itemsBatchList";
  }
  
  
  
  
  
  /**
   * @Title: updateBatchItems
   * @Description: 修改批量提交的商品信息
   * @param itemsCustomVO
   * @throws Exception
   * @return: String
   */
  //通过ItemsCustomVO接受批量提交的商品信息,将商品信息存储在ItemsCustomVO的itemsPOJOList属性中.
  @RequestMapping("/updateBatchItems")
  public String updateBatchItems(ItemsCustomVO itemsCustomVO) throws Exception{
   
    //..
    List<ItemsPOJO> itemsPOJOList = itemsCustomVO.getItemsPOJOList();
    for (ItemsPOJO itemsPOJO : itemsPOJOList) {
      System.out.println(itemsPOJO.getName());
    }
    return "forward:showBatchItems.do";
  }
}