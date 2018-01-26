package com.ek.basic.demo3.utils.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * @ClassName: CustomDateConverter
 * @Description: 日期转换器在springmvc.xml中配置的
 * @author: ek
 * @date: 2017年9月11日 下午4:53:05
 */
public class CustomDateConverter implements Converter<String, Date>{

  @Override
  public Date convert(String source) {
    //实现将日期串转成日期类型(yyyy-MM-dd HH:mm:ss)
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    try {
      //转换成功直接返回
      return simpleDateFormat.parse(source);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    //如果参数绑定失败返回null
    return null;
  }

   

}