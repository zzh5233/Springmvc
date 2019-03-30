<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<title>jackson的测试</title>
<script type="text/javascript">

//请求时json,输出为json
function requestJson(){
	
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/requestJson.action',
		contentType:'application/json;charset=utf-8',
		//数据格式为json串，商品信息
		data:'{"name":"手机","price":9999}',
		success:function(data){//返货json结果
			alert(data);
		}
		
	});
}
//请求时key/value,输出为json
function responseJson(){
	
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/responseJson.action',
		//请求时key/value这里不需要指定cententType,默认就是key/value
		//contentType:'application/json;chartset=utf-8',
		//数据格式为key/value
		data:'name=手机&price=9999',
		success:function(data){//返货json结果
			alert(data);
		}
		
	});
}
</script>

</head>
<body>

<input type="button" onclick="requestJson()" value="请求json串,输出json串" />
<input type="button" onclick="responseJson()" value="请求key/value,输出json串" />
</body>
</html>