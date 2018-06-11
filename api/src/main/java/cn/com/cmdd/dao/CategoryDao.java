package cn.com.cmdd.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.cmdd.domain.Category;

public interface CategoryDao {
	
	//:+
	void saveCategory(Category category);
	
	//:-
	void deleteCategory(@Param("id") Integer id);
	
	//:\
	void updateCategory(Category category);
	void updateIsUpload(Integer id);
	
	//:/
	List<Category> getCategory(@Param("shop_id") Integer shop_id, @Param("id") Integer id);
	List<Category> selectByIsUpload();
}
