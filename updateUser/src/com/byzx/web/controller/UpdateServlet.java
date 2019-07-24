package com.byzx.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.web.service.UserService;
import com.byzx.web.vo.User;

/**
 * Servlet implementation class UpdateServlet
 */
/*@WebServlet("/UpdateServlet")*/
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//拿到所有的值
		System.out.println("我在这");
		
		String uidstr = request.getParameter("uid");
		int uid = Integer.parseInt(uidstr);
		String uname = request.getParameter("uname");

		String sex = request.getParameter("sex");
		String agestr = request.getParameter("age");
		int age = Integer.parseInt(agestr);
		String address = request.getParameter("address");
		System.out.println("修改后的姓名为："+uname);
		System.out.println("修改后的年龄为："+age);
		
		User user = new User(uid,uname,sex,age,address );
		UserService service = new UserService();
		
		//调用service层的updateUser方法
		service.updateUser(user);
		//跳转页面
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
