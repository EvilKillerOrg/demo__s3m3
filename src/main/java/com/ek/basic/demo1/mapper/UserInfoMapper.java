package com.ek.basic.demo1.mapper;

import com.ek.basic.demo1.po.UserInfoD1;

/**
 * 测试Mapper方式开发, 测试方法在com.ek.demo1.test包中
 * @author EK
 * @date 2017年9月8日
 */
public interface UserInfoMapper {

  public abstract UserInfoD1 findUserInfoById(Integer uuid) throws Exception;
}