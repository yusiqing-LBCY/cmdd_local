package cn.com.cmdd.dao;



import java.util.List;

import cn.com.cmdd.domain.Member;

public interface MemberDao {
	
	void addMember(Member member);
	
	void deleteMember(int id);

	Member getMemberById(int id);

	void updateMember(Member member);
	
	List<Member> getMemberListByShop_id(int shop_id);
	
	void updateMemberPassword(int id, String pwdencry);
	
}
