package com.ek.basic.demo1.dao;

import com.ek.basic.demo1.po.UserInfoD1;
/**
 * 测试dao方式开发, 测试方法在com.ek.demo1.test包中
 * @author EK
 * @date 2017年8月28日
 */
public interface IUserInfoDAO {
  public abstract UserInfoD1 findUserInfoById(Integer uuid) throws Exception;
}