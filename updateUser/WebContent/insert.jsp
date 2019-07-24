<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加页面</title>
</head>
<body>
	<h1>我是添加页面</h1>
	<form action = "insertServlet" method = "post">
		ID：<input type = "text" value = "[***自动生成***]" readonly /><br/><br/>
		用户名：<input type = "text" name = "uname" > <br/><br/>
		密&nbsp;&nbsp;&nbsp;码：<input type = "password" name ="password" /><br/><br/>
		确认密码：<input type = "password" name ="cpassword" /><br/><br/>
		性&nbsp;&nbsp;&nbsp;别：
		<input type = "radio" name = "sex" value = "男"/>男
		<input type = "radio" name = "sex" value = "女"/>女<br/><br/>
		年&nbsp;&nbsp;&nbsp;龄：<input type = "number" name = "age"  > <br/><br/>
		地&nbsp;&nbsp;&nbsp;址：<input type = "text" name = "address"  > <br/><br/>
		<input type="submit" value ="确认注册" />
	</form>
	<script>
		
	
	
	
	
	</script>
	
	
	
</body>
</html>