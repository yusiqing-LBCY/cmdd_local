package cn.com.cmdd.dao;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.com.cmdd.domain.MemberCard;
import cn.com.cmdd.domain.MemberIntegral;


public interface MemberIntegralDao {

    @Select(value = "SELECT shop_id shopId,consume_money consumeMoney,consume_integral consumeIntegral,convert_integral convertIntegral,convert_money convertMoney FROM member_integral WHERE shop_id = #{shopId}")
    MemberIntegral select(@Param("shopId")Integer shopId);

   
    void insert(MemberIntegral memberIntegral);
    
    
    void update(MemberIntegral memberIntegral);

    //同步数据
  	List<MemberIntegral> selectByIsUpload();
  	int updateIsUpload(Long id);
}
