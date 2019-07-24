
<%@page import="com.byzx.web.vo.User"%>
<%@page import="java.util.List"%>
<%@page import="com.byzx.web.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>用户信息</title>
		<style type="text/css">
			table{
					font-size: 20px;/*调整表格里面的文本字体大小的*/
					text-align: center;/*调整内容在表格中的对齐方式，一般有三个值， left，center，right*/
					margin: 50px auto;
				}
				tr:nth-child(2n+2) {
					background-color:skyblue;
				}
				tr:first-child{
					background-color:yellow;
				}
		
		</style>
	</head>
	<body>
		<button onclick="insert.jsp">注册用户</button>
		<table border="1">
			
			<tr>
				<td>ID</td>
				<td>姓名</td>
				<td>密码</td>
				<td>性别</td>
				<td>年龄</td>
				<td>地址</td>
				<td>操作</td>
			</tr>
			<%
			//new对象调方法
			UserService service = new UserService();
			
			List<User> users = service.findUser();
			//遍历user对象
			for(User user:users){
			%>
			<tr>
				<td><%=user.getUid() %></td>
				<td><%=user.getUname() %></td>
				<td><%=user.getPassword() %></td>
				<td><%=user.getSex() %></td>
				<td><%=user.getAge() %></td>
				<td><%=user.getAddress() %></td>
				<td>
					<!-- 点击删除按钮，跳向DeleteServlet -->
					<a href = "deleteServlet?uid=<%=user.getUid()%>">删除</a>
					<a href = "update.jsp?uid=<%=user.getUid()%>">修改</a>
				</td>
			</tr>
			<%
			}
			%>
		</table>
		<form action="#" method="post">
<select>
<option >--请选择--</option>
<%
for(User user:users){
%>
  <option ><%=user.getUname() %></option>

<%
}
%>
</select>
</form>
	</body>
</html>