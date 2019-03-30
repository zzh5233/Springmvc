<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
</head>
<body>

<form name="itemForm" action="${pageContext.request.contextPath }/item/editItemsListSubmit.action" method="post">
修改商品信息：
<table width="100%" border=1>
<tr>
	<td>选择</td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
</tr>
<c:forEach items="${itemList}" var="item" varStatus="status">
<tr>
	<td><input type="checkbox" checked="checked" name="itemsList[${status.index }].id" value="${item.id}"/></td>
	<td><input type="text" name="itemsList[${status.index }].name" value="${item.name }"></td>
	<td><input type="text" name="itemsList[${status.index }].price" value="${item.price }"></td>
	<td><input type="text" name="itemsList[${status.index }].createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
	<td><input type="text" name="itemsList[${status.index }].detail" value="${item.detail}"></td>
</tr>
</c:forEach>
<tr>	
	<td colspan="5" align="right" ><input type="submit" value="保存"></td>
</tr>
</table>
</form>

</body>
</html>