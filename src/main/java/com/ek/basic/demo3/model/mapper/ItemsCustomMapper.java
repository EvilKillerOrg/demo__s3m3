package com.ek.basic.demo3.model.mapper;

import java.util.List;

import com.ek.basic.demo3.model.po.Items;
import com.ek.basic.demo3.model.pojo.ItemsPOJO;
import com.ek.basic.demo3.model.vo.ItemsCustomVO;

/**
 * 商品列表查询
 * @author EK
 * @date 2017年9月8日
 */
public interface ItemsCustomMapper {

  /* <!-- 商品列表查询, 
       parameterType 传入包装对象VO(包装了查询条件)
       resultType 传入扩展对象POJO(查询结果可以比原始PO的字段多) --> */
  public abstract List<ItemsPOJO> findItemsList(ItemsCustomVO itemsCustomVO) throws Exception;
  
  /* 根据id查询商品信息 */
  public abstract ItemsPOJO findItemsById(int id) throws Exception;
  
  /* 修改商品信息 修改的时候要注意 已经有图片的 不能把图片更新为null(有图片的时候没有上传直提交修改pic会获得一个null) */
  public abstract void updateItems(Items items) throws Exception;
  
}