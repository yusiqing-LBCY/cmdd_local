package cn.com.cmdd.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.cmdd.dao.PlatformDao;
import cn.com.cmdd.dao.UserDao;
import cn.com.cmdd.domain.User;
import cn.com.cmdd.util.Md5Helper;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PlatformDao platformDao;
	
	@Transactional
	public Integer addUser(User user){
		
		
		userDao.addUser(user);
		
		return user.getUser_id();
	}	
	
	@Transactional
	public User getUserByAccount(String account){
		
		return userDao.getUserByAccount(account);
	}	
	
	
	@Transactional  
	public Map<String,Object> login(String account, String password) throws Exception {
		Map<String,Object> resultMap = new HashMap<String,Object>();

		User user =  userDao.getUserByAccount(account);
		if(user != null){
			
			String pwdencry = Md5Helper.MD5Encode(password);
			Integer id = user.getUser_id();
			String user_keys = user.getUser_key();
			
			if(user.getUser_key().equals("1")){
				
				User user1 =  userDao.getUserPlatformByAccount(account);
				if(user1.getPassword().equals(pwdencry)){
					resultMap.put("user_keys",user_keys);
					resultMap.put("user_id",id);
					return resultMap;
				}else{
					throw new Exception("密码错误");
				}
			}else if(user.getUser_key().equals("2")){
				
				User user2 =  userDao.getUserAgentByAccount(account);
				if(user2.getIs_in_use() == 0){
					throw new Exception("账号未激活");
				}
				if(user2.getPassword().equals(pwdencry)){

					resultMap.put("user_keys",user_keys);
					resultMap.put("user_id",id);
					return resultMap;
					
				}else{
					throw new Exception("密码错误");
				}
				
			}else if(user.getUser_key().equals("3,4,5,6")){
				
				User user3 =  userDao.getUserShopByAccount(account);
				if(user3.getIs_in_use() == 0){
					throw new Exception("账号未激活");
				}
				
				if(user3.getPassword().equals(pwdencry)){

					resultMap.put("user_keys",user_keys);
					resultMap.put("user_id",id);
					return resultMap;
					
				}else{
					throw new Exception("密码错误");
				}
			}else{
				
				User user4 =  userDao.getUserStaffByAccount(account);
				if(user4.getIs_in_use() == 0){
					throw new Exception("账号未激活");
				}
				
				if(user4.getPassword().equals(pwdencry)){

					resultMap.put("user_keys",user_keys);
					resultMap.put("user_id",id);
					return resultMap;
					
				}else{
					throw new Exception("密码错误");
				}
			}
		
		}else{
			throw new Exception("登录名错误");
		}
	
	}
}
