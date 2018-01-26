package com.ek.basic.demo2.po;

import java.util.Date;
/**
 * 给测试dao方式用的po
 * @author EK
 * @date 2017年9月7日
 */
public class UserInfoD2 {
  private Integer uuid;
  private String userName;
  private Date birthday;
  private String Sex;
  public Integer getUuid() {
    return uuid;
  }
  public void setUuid(Integer uuid) {
    this.uuid = uuid;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public Date getBirthday() {
    return birthday;
  }
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
  public String getSex() {
    return Sex;
  }
  public void setSex(String sex) {
    Sex = sex;
  }
  @Override
  public String toString() {
    return "UserInfo [uuid=" + uuid + ", userName=" + userName + ", birthday=" + birthday + ", Sex=" + Sex + "]";
  }
}