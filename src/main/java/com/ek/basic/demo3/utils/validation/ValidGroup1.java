package com.ek.basic.demo3.utils.validation;

/**
 * @ClassName: ValidGroup1
 * @Description: 因为items 可能被多个controller使用 需要校验的条件可能不一样,所以要分组校验
 * @author: ek
 * @date: 2017年9月15日 下午10:14:39
 */
public interface ValidGroup1 {
  //接口中不用定义任何方法,仅是对不同的校验规则进行分组
  //ValidGroup1 只校验商品名称的长度
  //ValidGroup2 校验商品名称长度和生产日期
  
  //在po中给要验证的字段加上属于哪个分组就行了
  // @Size(min=1,max=30,message="{items.name.length.error}",groups={ValidGroup1.class,ValidGroup2.class})
  // @NotNull(message="{items.name.createTime.isNull}",groups={ValidGroup2.class})
}