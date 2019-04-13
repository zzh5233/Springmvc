<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<title>jackson2的测试</title>
<script type="text/javascript">

	//使用jquery来访问，返回jason数据
	$(document).ready(function(){
		$("#testJson").click(function(){
			$.post(){
				"testJson",	//服务器地址
				//{'name':'zs'}
				function(result){//回调函数 返回值被封装在result参数中
					for(var i=0; i<result.length; i++){
						alert(result[i].id+"-"+result[i].name+"-"+result[i].detail);						
					}
				}
			};
		
		});
		
	});
	
</script>

</head>
<body>

<input type="button" id="testJson" value="testJson">
</body>
</html>