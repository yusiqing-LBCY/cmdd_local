package cn.com.cmdd.dao;



import java.util.List;

import cn.com.cmdd.domain.MemberLotteryLog;

public interface MemberLotteryLogDao {
	void addMemberLotteryLog(MemberLotteryLog memberLotteryLogDao);

	MemberLotteryLog getMemberLotteryLogById(int id);

	void updateMemberLotteryLog(MemberLotteryLog memberLotteryLogDao);

	List<MemberLotteryLog> getMemberLotteryLogListByPhoneAndShopId(int shop_id, String phone);
	
	List<MemberLotteryLog> getMemberLotteryLogListByOrderId(Integer order_id);

	void deleteMemberLotteryLog(int id);
	
	MemberLotteryLog getMemberLotteryLogByOrderId(int Order_id);
	
}
