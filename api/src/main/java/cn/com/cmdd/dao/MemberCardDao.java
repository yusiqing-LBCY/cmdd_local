package cn.com.cmdd.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.com.cmdd.domain.MemberCard;

import java.util.List;

public interface MemberCardDao {

    @Insert("INSERT member_card VALUES(NULL,#{shopId},#{name},#{discount})")
    Integer insert(MemberCard memberCard);

    @Select("SELECT id,shop_id shopId,name,discount FROM member_card WHERE id = #{id}")
    MemberCard select(@Param("id") Integer id);

    @Select("SELECT id,shop_id shopId,name,discount FROM member_card WHERE shop_id = #{shopId} ORDER BY id")
    List<MemberCard> selectList(@Param("shopId") Integer shipId);

    @Update("UPDATE member_card SET name=#{name},discount=#{discount} WHERE id=#{id}")
    Integer update(MemberCard memberCard);

}
