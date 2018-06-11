package cn.com.cmdd.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.cmdd.dao.MemberDao;
import cn.com.cmdd.domain.Member;
import cn.com.cmdd.util.Md5Helper;

import java.util.List;

@Service
public class MemberService {
	private final static Logger LOGGER = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private MemberDao memberDao;
	
	@Transactional
	public Integer addMember(Member member) throws Exception{
		
		List<Member> memberList = memberDao.getMemberListByShop_id(member.getShop_id());
		for(Member ph : memberList){
			if(member.getPhone().equals(ph.getPhone())){
				throw new Exception("该手机号已注册");
			}
		}
		
		String pwdencry = Md5Helper.MD5Encode(member.getPay_password());
		member.setPay_password(pwdencry);
		
		memberDao.addMember(member);
		
		return member.getId();
	}	

	
	@Transactional
	public void deleteMember(int id){
		
		 memberDao.deleteMember(id);
	}
	
	
	@Transactional
	public Member getMember(int id){
		
		return memberDao.getMemberById(id);
	}
	
	@Transactional
	public List<Member> getMemberListByShop_id(int shop_id){
		
		return memberDao.getMemberListByShop_id(shop_id);
	}

	
	@Transactional
	public void updateMember(Member member){
	
		memberDao.updateMember(member);
	}
	
	@Transactional
	public Integer updateMemberPassword(int id,String newPwd) throws Exception{
		String pwdencry = Md5Helper.MD5Encode(newPwd);
		memberDao.updateMemberPassword(id, pwdencry);
		return id;
	}
	
}
