
package com.ek.basic.demo3.service;

import java.util.List;

import com.ek.basic.demo3.model.pojo.ItemsPOJO;
import com.ek.basic.demo3.model.vo.ItemsCustomVO;
/**
 * @ClassName: IItemsService
 * @Description: 商品信息Service接口
 * @author: ek
 * @date: 2017年9月9日 上午2:19:20
 */
public interface IItemsService {
  
  
  
  /**
   * @Title: findItemsList
   * @Description: 商品查询列表
   * @param itemsCustomVO
   * @throws Exception
   * @return: List<ItemsCustomPOJO>
   */
  public abstract List<ItemsPOJO> findItemsList(ItemsCustomVO itemsCustomVO) throws Exception;
  
  
  
  
  /**
   * @Title: findItemsById
   * @Description: 根据id查询商品信息
   * @param id
   * @return
   * @throws Exception
   * @return: ItemsCustomPOJO
   */
  public abstract ItemsCustomVO findItemsById (int id) throws Exception;
  
  
  
  /**
   * @Title: updateItems
   * @Description: 修改商品信息
   * @param id=修改商品的id
   * @param itemsCustomPOJO=itemsPO对象的扩展对象
   * @throws Exception
   * @return: void
   */
  /* 方法参数中加了一个id 是为了给别人看的 告诉别人调用这个方法的时候 只读要传一个id */
  public abstract void updateItems(Integer id, ItemsCustomVO itemsCustomVO) throws Exception;

}