package cn.com.cmdd.dao;



import java.util.List;

import cn.com.cmdd.domain.Staff;

public interface StaffDao {
	void addStaff(Staff staff);

	Staff getStaffById(int id);

	List<Staff> getStaffListByShop_id(int shop_id);
	
	List<Staff> getStaffList();

	void updateStaff(Staff staff);
	
	void deleteStaff(int id);
	
	void updateStaffPassword(int id, String newPwd);
	
	void updateShopPassword(int id, String newPwd);

}
