<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 显示错误信息 -->
<c:forEach items="${allErrors}" var="error" >
  ${error.defaultMessage}
</c:forEach>

  <form action="${pageContext.request.contextPath}/item/updateItems.do" method="post" enctype="multipart/form-data">
    <table align="center" border="1">
      <tr>
        <td>id:</td>
        <td><input name="itemsPOJO.id" value="${itemsCustomVO.itemsPOJO.id}"></td>
        <td>name:</td>
        <td><input name="itemsPOJO.name" value="${itemsCustomVO.itemsPOJO.name}"></td>
      </tr>
      <tr>
        <td>price:</td>
        <td><input name="itemsPOJO.price" value="${itemsCustomVO.itemsPOJO.price}"></td>
        <td>detail:</td>
        <td><input name="itemsPOJO.detail" value="${itemsCustomVO.itemsPOJO.detail}"></td>

      </tr>
      <tr>
        <td>pic:</td>
        <td>
          <c:if test="${itemsCustomVO.itemsPOJO.pic!=null}">
            <img src="/pic/s3m3/${itemsCustomVO.itemsPOJO.pic}" width="50px" height="50px" alt="pic">
          </c:if>
          <input type="file" name="multipartFile_pic">
        </td>
        <td>createTime:</td>
        <td><input name="itemsPOJO.createTime" value="<fmt:formatDate value="${itemsCustomVO.itemsPOJO.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/>"></td>
      </tr>
      <tr>
        <td colspan="4" align="center"><input type="submit"></td>
      </tr>
    </table>
  </form>
</body>
</html>