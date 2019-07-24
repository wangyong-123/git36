package com.byzx.web.service;

import java.util.List;


import com.byzx.web.dao.DBHelper;
import com.byzx.web.vo.User;

public class UserService {
	DBHelper helper = new DBHelper();
	//全查user表；
	public List<User> findUser() {
		return helper.findAllUser();
	}
	
	//根据ID删除用户
	public int  deleteUser(int uid) {
		return helper.deleteUser(uid);
	}
	public static void main(String[] args) {
		UserService service = new UserService();
		System.out.println(service.findUser());
	}
	//根据id查用户
	public User findUserById(int uid){
		return helper.findUserById(uid);
	}
	//更据id修改用户信息
	public int updateUser(User user) {
		return  helper.updateUser(user);
	}
	//向表中添加一条数据
	public int insertUser(User user) {
		return helper.insertUser(user);
	}
}

