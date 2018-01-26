<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h2>DEMO4设置了登录验证的拦截器,这会影响下面这些链接的执行,必须去demo4登录一下session有值了 再去访问这些链接</h2>

  <h2>DEMO1</h2>
  <br>
  DEMO1 的测试代码都在 test包中
  <br><br>
  
  <h2>DEMO2</h2>
  <br>
  <a href="${pageContext.request.contextPath}/queryUsers1_1.do">queryUsers1_1.do</a> <br>
  <a href="${pageContext.request.contextPath}/queryUsers1_2.do">queryUsers1_2.do</a> <br>
  <a href="${pageContext.request.contextPath}/queryUsers1_3.do">queryUsers1_3.do</a> <br>
  <a href="${pageContext.request.contextPath}/queryUsers2.do">queryUsers2.do</a> <br>
  <a href="${pageContext.request.contextPath}/queryUsers3.do">queryUsers3.do</a>
  <br><br>
  
  <h2>DEMO3</h2>
  <br>
  <a href="${pageContext.request.contextPath}/item/findItemsList.do">findItemsList.do</a> <br>
  <a href="${pageContext.request.contextPath}/json/testPage.do">jsonTest</a><br>
  <a href="${pageContext.request.contextPath}/rest/itemsView/1">RESTful(看这个url)</a>
  <br><br>
  
  <h2>DEMO4</h2>
  <a href="${pageContext.request.contextPath}/index.do">LoginInterceptor</a>
  
</body>
</html>