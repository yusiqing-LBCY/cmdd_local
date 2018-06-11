package cn.com.cmdd.dao;

import java.util.List;

import cn.com.cmdd.domain.Kitchen;

public interface KitchenDao {
	void addKitchen(Kitchen kitchen);

	Kitchen getKitchenById(int id);

	void updateKitchen(Kitchen kitchen);
	
	void deleteKitchen(int id);

	List<Kitchen> getKitchenListByShop_id(int shop_id);

}
