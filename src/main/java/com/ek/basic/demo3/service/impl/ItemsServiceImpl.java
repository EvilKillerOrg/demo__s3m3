package com.ek.basic.demo3.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ek.basic.demo3.model.mapper.ItemsCustomMapper;
import com.ek.basic.demo3.model.pojo.ItemsPOJO;
import com.ek.basic.demo3.model.vo.ItemsCustomVO;
import com.ek.basic.demo3.service.IItemsService;

/**
 * 
 * @ClassName: ItemsServiceImpl
 * @Description: 商量接口的实现类
 * @author: ek
 * @date: 2017年9月9日 上午2:11:22
 */
//这个类没有用annotation 这个类 是配置方式 放在IoC中的
public class ItemsServiceImpl implements IItemsService{

  //配置文件中扫描了这里就可以自动注入
  @Autowired
  private ItemsCustomMapper itemsCustomMapper;
  
  
  @Override
  public List<ItemsPOJO> findItemsList(ItemsCustomVO itemsCustomVO) throws Exception {
      
    return itemsCustomMapper.findItemsList(itemsCustomVO);
  }


  @Override
  public ItemsCustomVO findItemsById(int id) throws Exception {
    //mapper查询到商品信息表的数据
    ItemsPOJO itemsPOJO = itemsCustomMapper.findItemsById(id);
    
    /* 中间对商品信息进行业务处理 */
    /* ... */
    
    //需要返回ItemsCustomVO包装对象(除了包装商品信息,还可以包装用户等信息)
    ItemsCustomVO itemsCustomVO = new ItemsCustomVO(itemsPOJO);
    
    //Spring 自带了BeanUtils 将itemsPOJO 拷贝到 itemsCustomVO的itemsPOJO属性中
    //注意:这拷贝的时候没有判断不为nul
    BeanUtils.copyProperties(itemsPOJO,itemsCustomVO);
    
    return itemsCustomVO;
  }


  @Override
  public void updateItems(Integer id, ItemsCustomVO itemsCustomVO) throws Exception { //这里传vo可以在service处理商品信息 vo中包装了用户还能在这处理用户信息
    /* 这里要添加业务效验,效验id是否为空,为空抛出异常等操作 */
    itemsCustomVO.getItemsPOJO().setId(id); //这里需要再设一次id哪怕itemsPOJO里id属性是有值的,要保证这个id一定传过去
    itemsCustomMapper.updateItems(itemsCustomVO.getItemsPOJO());// mapper要的是Items这里可以直接传子类ItemsPOJO
  }

}