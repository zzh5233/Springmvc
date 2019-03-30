<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<script type="text/javascript">
function queryItem(){
	//提交表单
	document.itemForm.action="${pageContext.request.contextPath }/item/queryItem.action";
	document.itemForm.submit();
}
function deleteItems(){
	//提交表单
	document.itemForm.action="${pageContext.request.contextPath }/item/deleteItems.action";
	document.itemForm.submit();
}
function editItemsList(){
	//提交表单
	document.itemForm.action="${pageContext.request.contextPath }/item/editItemsList.action";
	document.itemForm.submit();
}
</script>

</head>
<body>
当前用户：${username }
<c:if test="${username != null }">
	<a href="${pageContext.request.contextPath }/logout.action">退出</a>
</c:if>
<form name="itemForm" action="${pageContext.request.contextPath }/item/queryItem.action" method="post">
查询条件:
<table width="100%" border=1>
<tr>
<td>
商品名称：<input type="text" name="itemCustom.name" value="${item.name }"/>
商品类型：
<select name="itemtype">
	<c:forEach items="${itemtypes}" var="itemtype">
		<option value="${itemtype.key }">${itemtype.value }</option>
	</c:forEach>
</select>
</td>
<td>
<input type="button" onclick="queryItem()" value="查询"/>
<input type="button" onclick="deleteItems()" value="批量删除"/>
<input type="button" onclick="editItemsList()" value="批量修改"/>
</td>
</tr>
</table>

商品列表：
<table width="100%" border=1>
<tr>
	<td>选择</td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>商品图片</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemList}" var="item">
<tr>
	<td><input type="checkbox" name="items_id" value="${item.id}"/></td>
	<td>${item.name }</td>
	<td>${item.price }</td>
	<td>${item.pic }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${item.detail }</td>

	<td><a href="${pageContext.request.contextPath }/item/editItem.action?id=${item.id}">修改</a></td>
</tr>
</c:forEach>
</table>
</form>

</body>
</html>