package cn.com.cmdd.dao;



import java.util.List;

import cn.com.cmdd.domain.Member;
import cn.com.cmdd.domain.MemberLotteryLog;

public interface MemberDao {
	
	void addMember(Member member);
	
	void deleteMember(Long id);

	Member getMemberById(Long id);

	void updateMember(Member member);
	
	List<Member> getMemberListByShop_id(int shop_id);
	
	void updateMemberPassword(Long id, String pwdencry);
	
	//同步数据
	List<Member> selectByIsUpload();
	int updateIsUpload(Long id);
}
