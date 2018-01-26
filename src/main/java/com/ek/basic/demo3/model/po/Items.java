package com.ek.basic.demo3.model.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ek.basic.demo3.utils.validation.ValidGroup1;
import com.ek.basic.demo3.utils.validation.ValidGroup2;

/**
 * 商品信息表 m_items
 * 
 * @author EK
 * @date 2017年8月26日
 */
public class Items {
  private Integer id;
  
  //校验名字为1到30个字符之间(message是检验错误提示信息)
  //groups标识本校验属于哪个分组
  @Size(min=1,max=30,message="{items.name.length.error}",groups={ValidGroup1.class,ValidGroup2.class})
  private String name;
  
  private Float price;
  private String detail;
  private String pic;
  
  //非空校验
  @NotNull(message="{items.name.createTime.isNull}",groups={ValidGroup2.class})
  private Date createTime;

  
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

}