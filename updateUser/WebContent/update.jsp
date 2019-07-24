<%@page import="com.byzx.web.vo.User"%>
<%@page import="com.byzx.web.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>修改用户</title>
	</head>
	<body>
	<H1>修改用户信息</H1>
	<!-- 获取index.jsp 传过来的uid -->
		<%
		String uidstr = request.getParameter("uid");
		System.out.println("要修改的用户id为"+uidstr);
		if(null == uidstr){
			return;
		}
		int uid = Integer.parseInt(uidstr);
		//调用service方法
		UserService service = new UserService();
		User user = service.findUserById(uid);
		%>
		<!-- 后台要能获取表单的值，前提是要每个input有name属性 -->
		<form action= "updateServlet" method ="post" >
			
			ID:<input type="text" name="uid" value="<%=user.getUid()%>" readonly/><br/><br/>
			用户名:<input type="text" name ="uname" value="<%=user.getUname()%>"/><br/><br/>
			性别:
			<input type="radio" name ="sex"value="男"/>男
			<input type="radio" name ="sex"value="女"/>女
			<br/><br/>
			
			年龄:<input type="text" name = "age" value="<%=user.getAge()%>"/><br/><br/>
			地址:<input type="text" name = "address" value="<%=user.getAddress()%>"/><br/><br/>
			
			<input type="submit" value ="确认修改" />
		
		<script>
			var sex ="<%=user.getSex() %>"
			var sexes = document.getElementsByName("sex");
			if(sex=="男"){
				sexes[0].checked = true;
			}else if (sex == "女"){
				sexes[1].checked = true;
			}
		</script>
		</form>
	</body>
</html>