package cn.com.cmdd.dao;



import java.util.List;

import cn.com.cmdd.domain.MemberLotteryLog;
import cn.com.cmdd.domain.MemberRechargeLog;

public interface MemberLotteryLogDao {
	void addMemberLotteryLog(MemberLotteryLog memberLotteryLogDao);

	MemberLotteryLog getMemberLotteryLogById(Long id);

	void updateMemberLotteryLog(MemberLotteryLog memberLotteryLogDao);

	List<MemberLotteryLog> getMemberLotteryLogListByPhoneAndShopId(int shop_id, String phone);
	
	List<MemberLotteryLog> getMemberLotteryLogListByOrderId(Integer order_id);

	void deleteMemberLotteryLog(Long id);
	
	MemberLotteryLog getMemberLotteryLogByOrderId(Long Order_id);
	
	//同步数据
	List<MemberLotteryLog> selectByIsUpload();
    int updateIsUpload(Long id);
	
}
