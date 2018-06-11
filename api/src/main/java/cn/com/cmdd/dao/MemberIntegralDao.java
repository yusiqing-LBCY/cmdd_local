package cn.com.cmdd.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import cn.com.cmdd.domain.MemberIntegral;


public interface MemberIntegralDao {

    @Select(value = "SELECT shop_id shopId,consume_money consumeMoney,consume_integral consumeIntegral,convert_integral convertIntegral,convert_money convertMoney FROM member_integral WHERE shop_id = #{shopId}")
    MemberIntegral select(@Param("shopId")Integer shopId);

    @Insert(value = "INSERT INTO member_integral(shop_id,consume_money,consume_integral,convert_integral,convert_money)VALUES(#{shopId},#{consumeMoney},#{consumeIntegral},#{convertIntegral},#{convertMoney}) ON DUPLICATE KEY UPDATE consume_money=#{consumeMoney},consume_integral=#{consumeIntegral},convert_integral = #{convertIntegral},convert_money=#{convertMoney}")
    int saveAndUpdateOne(MemberIntegral memberIntegral);

}
