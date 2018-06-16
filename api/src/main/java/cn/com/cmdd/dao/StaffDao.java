package cn.com.cmdd.dao;



import java.util.List;

import cn.com.cmdd.domain.Staff;
import cn.com.cmdd.domain.User;

public interface StaffDao {
	Long addStaff(Staff staff);

	Staff getStaffById(Long id);

	List<Staff> getStaffListByShop_id(int shop_id);
	
	List<Staff> getStaffList();

	void updateStaff(Staff staff);
	
	void deleteStaff(Long id);
	
	void updateStaffPassword(Long id, String newPwd);
	
	void updateShopPassword(Long id, String newPwd);
	
	//同步数据
	List<Staff> selectByIsUpload();
	void updateIsUpload(Long id);


}
