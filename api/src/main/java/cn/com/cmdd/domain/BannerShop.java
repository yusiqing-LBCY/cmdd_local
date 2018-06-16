package cn.com.cmdd.domain;

import org.apache.ibatis.type.Alias;

@Alias("BannerShop")
public class BannerShop {
	private Integer  id;
	private Long banner_id;
	private Integer shop_id;
	private Integer serial;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getBanner_id() {
		return banner_id;
	}
	public void setBanner_id(Long banner_id) {
		this.banner_id = banner_id;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	
}
