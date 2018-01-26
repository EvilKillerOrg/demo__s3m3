<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteItem() {
		document.itemForm.action = "${pageContext.request.contextPath}/item/deleteItems.do";
		document.itemForm.submit();
	}
	function findItemsList() {
		document.itemForm.action = "${pageContext.request.contextPath}/item/findItemsList.do";
		document.itemForm.submit();
	}
</script>
</head>
<body>
  <form name="itemForm" action="" method="post">
    <table align="center" border="1" width="50%">
      <tr>
        <td>name:<input type="text" name="itemsPOJO.name" value="${itemsCustomVO.itemsPOJO.name}"> 
                 <input type="button" value="Submit"  onclick="findItemsList()">
        </td>
      </tr>
      <tr>
        <td><input type="button" value="BzatchDelete" onclick="deleteItem()"></td>
      </tr>
      <tr>
        <td><a href="${pageContext.request.contextPath}/item/showBatchItems.do">showBatchItems</a></td>
      </tr>
    </table>

    <table align="center" border="1" width="50%">
      <tr>
        <td>&nbsp;</td>
        <td>id:&nbsp;</td>
        <td>name:&nbsp;</td>
        <td>price:&nbsp;</td>
        <td>detail:&nbsp;</td>
        <td>pic:&nbsp;</td>
        <td>createTime:&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <c:forEach items="${itemsList}" var="items">
        <tr>
          <td><input type="checkbox" name="item_id" value="${items.id}"></td>
          <td>${items.id}</td>
          <td>${items.name}</td>
          <td>${items.price}</td>
          <td>${items.detail}</td>
          <td><img alt="pic" src="/pic/s3m3/${items.pic}" width="50px" height="50px"></td>
          <td><fmt:formatDate value="${items.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
          <td><a href="${pageContext.request.contextPath}/item/findItemsById.do?id=${items.id}">修改</a></td>
        </tr>
      </c:forEach>
    </table>
  </form>
</body>
</html>