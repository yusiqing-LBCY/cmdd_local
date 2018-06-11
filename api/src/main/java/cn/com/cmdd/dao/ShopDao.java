package cn.com.cmdd.dao;

import java.util.List;

import cn.com.cmdd.domain.Banner;
import cn.com.cmdd.domain.Shop;

public interface ShopDao {
	void addShop(Shop shop);

	void deleteShop(int id);
	
	Shop getShopById(int id);
	
	Shop getShopByAccount(String account);
	
	List<Shop> getShopList();
	
	List<Shop> getShopListByAgent_id(int agent_id);
	
	void updateShop(Shop shop);
	
	void updateShopPayCodeId(Shop shop);
	
	void updateAgentPassword(int id, String newPwd);
	
	void updateShopPassword(int id, String newPwd);
	
	void updateStaffPassword(int id, String newPwd);
	
	List<Banner> getBannerListByAgentId(int agent_id);
	
	//public abstract List<Banner> getBannerListByShopId(int shop_id);
}
