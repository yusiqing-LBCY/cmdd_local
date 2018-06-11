package cn.com.cmdd.dao;



import org.apache.ibatis.annotations.Param;

import cn.com.cmdd.domain.OrderCount;
import cn.com.cmdd.domain.Orders;
import cn.com.cmdd.domain.OrdersCountModel;

import java.util.Date;
import java.util.List;

public interface OrdersDao {
	//:+
	void saveOrders(Orders orders);
	//-
	void deleteOrders(@Param("id") Integer id);
	void deleteCallService(@Param("orderId")Integer orderId);	
	void deleteOrderItemByDiningTableId(@Param("diningTableId") Integer diningTableId);
	void deleteCallServiceByDiningTableId(@Param("diningTableId")Integer diningTableId);
    void deleteMemberLotterLogByOrderId(@Param("orderId")Integer orderId);
    //:\
    void updateIsUpload(@Param("id")Integer id);
    
	void updateOrders(Orders Order);
	void resetOrderPno(@Param("shopId") Integer shopId);
	void unifyOrderNo(
			@Param("diningTablePid") Integer pId,
			@Param("diningTableIdList") List<Integer> idList);
	void resetDiningTable(@Param("id")Integer id);
	//:/
	List<Orders> selectByIsUpload(); 
	Orders selectByDiningTableAndStatusId(
			@Param("diningTableId")Integer diningTableId,
			@Param("statusId")Integer statusId);
	List<Integer> selectIdListByPId(@Param("PId") Integer PId);
	List<Orders> selectListById(@Param("id") Integer id);
	List<Orders> selectList(
            @Param("shop_id") Integer shop_id,
            @Param("id") Integer id,
            @Param("page_size") Integer page_size,
            @Param("pageStart_index") Integer pageStart_index,
            @Param("dining_table_id") Integer dining_table_id,
            @Param("start_time") Date start_time,
            @Param("end_time") Date end_time,
            @Param("statusList") List<Integer> statusList,
            @Param("typePay")Integer typePay);
	List<OrderCount> getOrdersCount(
            @Param("shop_id") Integer shop_id,
            @Param("start_time") Date start_time,
            @Param("end_time") Date end_time,
            @Param("statusList") List<Integer> statusList);
	OrdersCountModel getOrderPayCount( 
			@Param("shop_id") Integer shop_id,
            @Param("start_time") Date start_time,
            @Param("end_time") Date end_time);
	double selectDiscoutPreferential(
			@Param("shopId")Integer shopId, 
			@Param("startTime")Date startTime, 
			@Param("endTime")Date endTime);




}
