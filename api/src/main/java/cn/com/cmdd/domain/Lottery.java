package cn.com.cmdd.domain;
import org.apache.ibatis.type.Alias;

@Alias("Lottery")
public class Lottery {
	private Integer id;
	private Integer levels;
	private Double 	quantity;
	private Integer shop_id;
	private String 	prize;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLevels() {
		return levels;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	
}
