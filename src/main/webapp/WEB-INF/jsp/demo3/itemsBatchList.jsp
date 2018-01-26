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
  <form name="itemForm" action="${pageContext.request.contextPath}/item/updateBatchItems.do" method="post">
    <table align="center" border="1" width="50%">
      <tr>
        <td>id:&nbsp;</td>
        <td>name:&nbsp;</td>
        <td>price:&nbsp;</td>
        <td>detail:&nbsp;</td>
        <td>pic:&nbsp;</td>
        <td>createTime:&nbsp;</td>
      </tr>
      <c:forEach items="${itemsList}" var="items" varStatus="status">
        <tr>
          <td><input name="itemsPOJOList[${status.index}].id" value="${items.id}"></td>
          <td><input name="itemsPOJOList[${status.index}].name" value="${items.name}"></td>
          <td><input name="itemsPOJOList[${status.index}].price" value="${items.price}"></td>
          <td><input name="itemsPOJOList[${status.index}].detail" value="${items.detail}"></td>
          <td><input name="itemsPOJOList[${status.index}].pic" value="${items.pic}"></td>
          <td><input name="itemsPOJOList[${status.index}].createTime" value="<fmt:formatDate value="${items.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/>"></td>
        </tr>
      </c:forEach>
      <tr>
        <td colspan="6"><input type="submit" value="Submit"></td>
      </tr>
    </table>
  </form>
</body>
</html>