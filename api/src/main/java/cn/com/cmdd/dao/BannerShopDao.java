package cn.com.cmdd.dao;

import java.util.List;

import cn.com.cmdd.domain.BannerShop;

public interface BannerShopDao {
	
	void addBannerShop(BannerShop bannerShop);
	
	void deleteBannerShop(int id);
	
	void updateBannerShop(BannerShop bannerShop);
	
	List<BannerShop> getBannerShopByBannerId(int bannerId);
	
	List<BannerShop> getBannerShopByShopId(int shopId);

}
