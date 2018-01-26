<%@ page language="java" import="javax.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json交互测试</title>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
  //请求是json,输出是json
  function requestJson() {
    $.ajax({
      type:'post',
      url:'${pageContext.request.contextPath }/json/requestJson.do',
      contentType:'application/json;charset=UTF-8',
      data:'{"name":"手机","price":999}',//数据格式是json串
      success:function(data){//返回json结果
        alert(data);
      }
    });
  }

  //请求是key/value,输出是json
  function responseJson() {
    $.ajax({
      type:'post',
      url:'${pageContext.request.contextPath }/json/responseJson.do',
      data:'name=电话&price=888',//数据格式是key/value不用contentType(有默认值)
      success:function(data){//返回json结果
        alert(data.name);
      }
    });
  }
</script>
</head>
<body>
  <p align="center">
    <input type="button" value="请求是json,输出是json" onclick="requestJson();">
  </p>

  <p align="center">
    <input type="button" value="请求是key/value,输出是json" onclick="responseJson();">
  </p>


</body>
</html>