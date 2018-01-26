package com.ek.basic.demo3.model.vo;

import java.util.List;

import javax.validation.Valid;

import com.ek.basic.demo3.model.po.Items;
import com.ek.basic.demo3.model.pojo.ItemsPOJO;

/**
 * 商品信息的包装对象
 * 
 * @author EK
 * @date 2017年9月8日
 */
public class ItemsCustomVO {

  private Items Items;

  // 为了系统的可扩展性,对原始生成的po进行扩展,在包装对象中把扩展对象包进来
  @Valid
  private ItemsPOJO itemsPOJO;
  
  
  // 为了集合对象的绑定 接页面提交的批量数据
  private List<ItemsPOJO> itemsPOJOList;

  public ItemsCustomVO() {
  }

  // 这个构造方法是给service使用BeanUtils的时候用的
  public ItemsCustomVO(ItemsPOJO itemsPOJO) {
    this.itemsPOJO = itemsPOJO;
  }

  
  
  
  
  
  public Items getItems() {
    return Items;
  }

  public void setItems(Items items) {
    Items = items;
  }

  public ItemsPOJO getItemsPOJO() {
    return itemsPOJO;
  }

  public void setItemsPOJO(ItemsPOJO itemsPOJO) {
    this.itemsPOJO = itemsPOJO;
  }

  public List<ItemsPOJO> getItemsPOJOList() {
    return itemsPOJOList;
  }

  public void setItemsPOJOList(List<ItemsPOJO> itemsPOJOList) {
    this.itemsPOJOList = itemsPOJOList;
  }

}