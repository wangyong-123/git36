package com.byzx.web.dao;

import java.util.List;

import com.byzx.web.vo.User;

public class DBHelper {
	//全查user表
	public List<User> findAllUser(){
		String sql = "select *from user";
		return DBUtils.findUser(sql);
	}
	//根据ID删除用户
	public int  deleteUser(int uid) {
		String sql = "delete from user where uid = "+uid;
		return DBUtils.updateTable(sql);
	}
	//根据id查用户
	public User findUserById(int uid){
		String sql = "select * from user where uid="+uid;
		List<User> users = DBUtils.findUser(sql);
		return users.size()==0?null:users.get(0);
	}
	//更据id修改用户信息
	public int updateUser(User user) {
		String sql = "update user set uname='" + user.getUname() + "',sex='" + user.getSex() + "',age=" + user.getAge() + ",address='" + user.getAddress() + "' where uid=" + user.getUid();
		return DBUtils.updateTable(sql);
	}
	//向表中插入一条数据
	public int insertUser(User user) {
		System.out.println("查询语句中的user对象"+user);
		String sql = "insert into user(uname,password,sex,age,address) values('" + user.getUname() + "','" + user.getPassword() + "','" + user.getSex() +"'," + user.getAge() +",'"+ user.getAddress() + "')";
		return DBUtils.updateTable(sql);
	}
	public static void main(String[] args) {
		String sql = "insert into user(uname,password,sex,age,address) values('张三丰','123456','男',23,'宁县')";
		DBUtils.updateTable(sql);
	}

}
