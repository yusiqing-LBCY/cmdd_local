package cn.com.cmdd.dao;


import org.apache.ibatis.annotations.Param;

import cn.com.cmdd.domain.Dining_table;

import java.util.List;

/**
 * 
 * @typeName Dining_table
 * @description 
		Summary : TODO 
		Member Property :TODO
		Member Method:TODO
 * @author yusiqing
 * @date 2017年6月12日 上午10:22:03
 */
public interface Dining_tableDao{
	//+
	void saveDining_table(Dining_table dt);
	//-
	void deleteDining_table(Integer id);
	//\
	void updateDining_table(Dining_table dt);
	void updateStatus(@Param("status")Integer status,@Param("id")Integer id);
	///
	List<Dining_table> getDining_table(@Param("shop_id") Integer shop_id, @Param("id") Integer id);
	Dining_table select(@Param("id")Integer id);
	List<Dining_table> selectListByShopId(@Param("shopId")Integer shopId);
	
}
