package com.ek.basic.demo1.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ek.basic.demo1.po.UserInfoD1;

/**
 * 测试dao方式开发
 * 继承 SqlSessionDaoSupport 给本UserInfoDAOImpl注入sqlSessionFactory就等于注入给了它, 由它来获得SqlSession
 * @author EK
 * @date 2017年8月28日
 */
public class UserInfoDAOImpl extends SqlSessionDaoSupport implements IUserInfoDAO{
 
  
  @Override
  public UserInfoD1 findUserInfoById(Integer uuid) throws Exception {
    SqlSession sqlSession = this.getSqlSession();
    UserInfoD1 user = sqlSession.selectOne("textdao.findUserInfoById", 1);
    // sqlSession.close(); spring 管理了这里就不用关闭了
    return user;
  }
  
  
  
}