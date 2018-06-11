package cn.com.cmdd.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.cmdd.dao.ImageDao;
import cn.com.cmdd.dao.KitchenDao;
import cn.com.cmdd.domain.Kitchen;

import java.util.List;

@Service
public class KitchenService {
	private final static Logger LOGGER = LoggerFactory.getLogger(KitchenService.class);
	
	@Autowired
	private KitchenDao kitchenDao;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ImageDao imageDao;
	
	@Transactional
	public Integer addKitchen(Kitchen kitchen){
		
		kitchenDao.addKitchen(kitchen);
		return kitchen.getId();
	}	
	
	
	@Transactional
	public void deleteKitchen(int id){
		
		Kitchen kitchen = kitchenDao.getKitchenById(id);
		imageService.DeleteImage(kitchen.getLogo_id());
		imageDao.deleteImage(kitchen.getLogo_id());
		
		 kitchenDao.deleteKitchen(id);
	}
	
	
	@Transactional
	public Kitchen getKitchen(int id){
		
		return kitchenDao.getKitchenById(id);
	}
	
	@Transactional
	public List<Kitchen> getKitchenList(int shop_id){
		
		return kitchenDao.getKitchenListByShop_id(shop_id);
	}

	
	@Transactional
	public void updateKitchen(Kitchen kitchen){
	
		kitchenDao.updateKitchen(kitchen);
	}
	
	
	
}
