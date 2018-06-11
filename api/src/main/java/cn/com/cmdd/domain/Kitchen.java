package cn.com.cmdd.domain;

import org.apache.ibatis.type.Alias;

@Alias("Kitchen")
public class Kitchen {
	private Integer id;
	private Integer shop_id;
	private Integer logo_id;	
	private String 	description;
	private String 	title;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public Integer getLogo_id() {
		return logo_id;
	}
	public void setLogo_id(Integer logo_id) {
		this.logo_id = logo_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
}

















