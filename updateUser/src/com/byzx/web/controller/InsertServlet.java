package com.byzx.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.web.service.UserService;
import com.byzx.web.vo.User;

/**
 * Servlet implementation class InsertServlet
 */
/*@WebServlet("/InsertServlet")*/
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String agestr = request.getParameter("age");
		if(agestr == null) {
			return;
		}
		int age = Integer.parseInt(agestr);
		String address = request.getParameter("address");
		//查看注册页面过来的值是否被接收到
		System.out.println("注册的姓名为："+uname);
		System.out.println("注册的密码为："+password);
		System.out.println("注册的性别为："+sex);
		System.out.println("注册的年龄为："+age);
		System.out.println("注册的地址为："+address);
		
		User user = new User(uname,password,sex,age,address);
		UserService service = new UserService();
		//调用service层的方法
		service.insertUser(user);
		//跳转index.jsp页面
		System.out.println("*******InsertServlet*********");
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
