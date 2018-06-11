package cn.com.cmdd.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.cmdd.dao.AgentDao;
import cn.com.cmdd.dao.ImageDao;
import cn.com.cmdd.dao.ShopDao;
import cn.com.cmdd.dao.UserDao;
import cn.com.cmdd.domain.Agent;
import cn.com.cmdd.domain.Banner;
import cn.com.cmdd.domain.Shop;
import cn.com.cmdd.domain.User;
import cn.com.cmdd.util.Md5Helper;

@Service
public class ShopService {
	private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ShopService.class);
	
	@Autowired
	private ShopDao shopDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	private ImageDao imagedDao;
		
	@Transactional
	public Integer addShop(Shop shop){
		//判断是否使用服务费
		/*Integer is_use_service = shop.getIs_use_service();		
		if(is_use_service != null&&is_use_service==1) {
			Integer agent_id = shop.getAgent_id();
			Agent agentById = agentDao.getAgentById(agent_id);
			Double serviceCharge = agentById.getService_charge();
			shop.setService_charge(serviceCharge);
		}*/
		
		String pwdencry = Md5Helper.MD5Encode(shop.getPassword());
		shop.setPassword(pwdencry);
			
		String account;
		List<Shop> shopList = shopDao.getShopList();
		int size = shopList.size();
		
		if(size==0){
			account = "s100001";
		}else{
			int index = (shopList.size())-1;
			String str = shopList.get(index).getAccount();
			String[] split = str.split("s");
			Integer sss = Integer.parseInt(split[1])+1;
			account = "s"+sss;
			
		}
		shop.setAccount(account);
		shop.setIs_banner(0);
		shop.setIs_unified_print(1);
		
		shop.setPayable_date(1);
		shopDao.addShop(shop);
		User user = new User();
		user.setAccount(shop.getAccount());
		user.setUser_id(shop.getId());
		user.setUser_key(shop.getUser_key());
		userDao.addUser(user);
		
		
		return shop.getId();
	}	
	
	
	@Transactional
	public void deleteShop(int id){
		
		 shopDao.deleteShop(id);
	}
	
	
	@Transactional
	public Shop getShop(int id){
		
		return shopDao.getShopById(id);
	}
	
	@Transactional
	public List<Shop> getShopList(){
		
		return shopDao.getShopList();
	}

	
	@Transactional
	public List<Shop> getShopListByAgent_id(int agent_id){
		
		return shopDao.getShopListByAgent_id(agent_id);
	}
	
	@Transactional
	public List<Banner> getBannerListByAgentId(int agent_id) throws Exception{
		
		return shopDao.getBannerListByAgentId(agent_id);
	}
	
	/*@Transactional
	public List<Banner> getBannerListByShopId(int shop_id) throws Exception{
		
		return shopDao.getBannerListByShopId(shop_id);
	}*/
	
	@Transactional
	public void updateShop(Shop shop){
		//判断是否使用服务费
/*		Integer is_use_service = shop.getIs_use_service();
		if(is_use_service==null) {
			shop.setService_charge(null);
		}else if(is_use_service==1) {
			Integer agent_id = shop.getAgent_id();
			Agent agentById = agentDao.getAgentById(agent_id);
			Double serviceCharge = agentById.getService_charge();
			shop.setService_charge(serviceCharge);
		}else if(is_use_service==0){			
			shop.setService_charge(0.0);
		}
*/		
		String password = shop.getPassword();
		if(password.equals("000000")){
			String pwdencry = Md5Helper.MD5Encode(password);
			shop.setPassword(pwdencry);
		}
		shopDao.updateShop(shop);
		
	}
/**
* 2017/09/03
* zhangpeng
* 删除付款码操作
*/
	@Transactional
	public void updateShopPayCodeId(Shop shop){
		
			imagedDao.deleteImage(shop.getPay_code_id());
			shop.setPay_code_id(null);
			shopDao.updateShopPayCodeId(shop);
		
	}
	
	@Transactional
	public Integer updateAgentPassword(int id,String oldPwd,String newPwd) throws Exception{
		
		Agent agent = agentDao.getAgentById(id);
		String pwdencry = Md5Helper.MD5Encode(oldPwd);
		if(pwdencry.equals(agent.getPassword())){
			pwdencry = Md5Helper.MD5Encode(newPwd);
			shopDao.updateAgentPassword(id, pwdencry);
		}else{
			throw new Exception("原密码错误");
		}
		return id;
	}
	
}
