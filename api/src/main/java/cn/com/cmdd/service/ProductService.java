package cn.com.cmdd.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.cmdd.dao.ProductDao;
import cn.com.cmdd.domain.Product;

import java.util.List;


/**
 * 
 * @typeName ProductService
 * @description 
		Summary : TODO 
		Member Property :TODO
		Member Method:TODO
 * @author yusiqing
 * @date 2017年6月14日 上午7:56:08
 */
@Service
@Transactional
public class ProductService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductDao productDao;

	public Integer saveProduct(Product product){

		productDao.insert(product);

		return product.getId();
	}
	
	public void deleteProduct(Integer id){
		productDao.delete(id);
	}
	
	public void updateProduct(Product product){
		productDao.update(product);
	}
	
	public List<Product> getProduct(Integer shop_id, Integer id, Integer category_id){

		return productDao.selectListByShopIdAndIdAndCategoryId(shop_id, id, category_id);
	}
}
