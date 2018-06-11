package cn.com.cmdd.dao;

import cn.com.cmdd.domain.User;

public interface UserDao {
	void addUser(User user);
	
	User getUserByAccount(String account);
	
	User getUserPlatformByAccount(String account);
	
	User getUserAgentByAccount(String account);
	
	User getUserShopByAccount(String account);
	
	User getUserStaffByAccount(String account);
}
