package cn.com.cmdd.dao;

import java.util.List;

import cn.com.cmdd.domain.User;

public interface UserDao {
	void addUser(User user);
	
	User getUserByAccount(String account);
	
	User getUserPlatformByAccount(String account);
	
	User getUserAgentByAccount(String account);
	
	User getUserShopByAccount(String account);
	
	User getUserStaffByAccount(String account);
	
	//同步数据
	List<User> selectByIsUpload();
	void updateIsUpload(Long id);
}
