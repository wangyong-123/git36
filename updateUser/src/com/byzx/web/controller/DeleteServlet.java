package com.byzx.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.web.service.UserService;

/**
 * Servlet implementation class DeleteServlet
 */
/*@WebServlet("/DeleteServlet")*/
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取index.jsp传递过来的参数
		String uidstr = request.getParameter("uid");
		if(null==uidstr) {
			return;
		}
		int uid = Integer.parseInt(uidstr);
		//检查数据是否从页面传向后台
		System.out.println("uidstr:"+uidstr);
		//2.调用service方法
		UserService service = new UserService();
		//
		service.deleteUser(uid);
		//3.调回index.sp
		//重定向
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
