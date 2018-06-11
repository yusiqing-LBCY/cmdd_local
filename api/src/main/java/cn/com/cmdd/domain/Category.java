package cn.com.cmdd.domain;

import org.apache.ibatis.type.Alias;

@Alias("category")
public class Category {
	private Integer id;
	private Integer shop_id;
	private String name;
	private Integer is_enable;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Integer id, Integer shop_id, String name, Integer is_enable) {
		super();
		this.id = id;
		this.shop_id = shop_id;
		this.name = name;
		this.is_enable = is_enable;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIs_enable() {
		return is_enable;
	}
	public void setIs_enable(Integer is_enable) {
		this.is_enable = is_enable;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", shop_id=" + shop_id + ", name=" + name + ", is_enable=" + is_enable + "]";
	}
	
}
