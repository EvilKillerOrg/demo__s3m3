package com.ek.basic.demo3.model.pojo;

import com.ek.basic.demo3.model.po.Items;

/**
 * @ClassName: ItemsCustomPOJO
 * @Description: 商品信息的扩展对象
 * @author: ek
 * @date: 2017年9月9日 上午2:31:35
 */
public class ItemsPOJO extends Items {
  
  // 比如可以根据表中的生产日期字段经过在service中的处理给这里封装一个是否过期的属性 
  // 还有比如用户表根据身份证号码 扩展出年龄 性别 等信息
  
  
  /*校验: 由于pojo是继承po的 所以校验的东西写在po里 去po中看*/
  
}