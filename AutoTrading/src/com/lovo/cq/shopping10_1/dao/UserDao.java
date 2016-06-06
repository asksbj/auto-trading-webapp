package com.lovo.cq.shopping10_1.dao;

import java.util.List;
import com.lovo.cq.shopping10_1.po.User;

public interface UserDao {
	public boolean addUser(User user);
	
	public User getUser(int userid);
	
	public User getBuyers(int carid);
	
	public boolean updateUser(User user);

	public User userLogin(String name,String password);
	
	public boolean addBuyer(int userid);
	
	public boolean addSeller(int userid);

	
}
