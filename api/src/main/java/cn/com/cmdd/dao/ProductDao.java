package cn.com.cmdd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.cmdd.domain.Product;

/**
 * 
 * @typeName ProductDao
 * @description 
		Summary : TODO 
		Member Property :TODO
		Member Method:TODO
 * @author yusiqing
 * @date 2017年6月14日 上午7:55:04
 */
public interface ProductDao{
	void insert(Product dt);
	void delete(Integer id);
	void update(Product dt);

	Product select(@Param("id") Integer id);

	List<Product> selectListByShopIdAndIdAndCategoryId(
            @Param("shop_id") Integer shop_id,
            @Param("id") Integer id,
            @Param("category_id") Integer category_id
    );
}
