package com.ek.basic.demo3.utils.exception;

/**
 * @ClassName: CustomException
 * @Description: 自定义的异常类,针对预期的异常,需要在程序中抛出此类异
 * @author: ek
 * @date: 2017年9月15日 下午11:43:33
 */
public class CustomException extends Exception {
 
  private static final long serialVersionUID = 1L;
  
  // 异常信息
  public String message;

  public CustomException(String message) {
    super(message);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMassage(String message) {
    this.message = message;
  }

}