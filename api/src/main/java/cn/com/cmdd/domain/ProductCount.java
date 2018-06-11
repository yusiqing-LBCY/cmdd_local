package cn.com.cmdd.domain;



import org.apache.ibatis.type.Alias;
@Alias("ProductCount")
public class ProductCount {
	private int id;
	private int logo_id;
	private String name;
	private String category_name ;
	private double sumCount;
	private int is_promotion;
	private double unit_price;
	private double promotion_price;
	private double quantity;	
	private double sumIsLottery;

	public ProductCount() {
		super();
		// TODO Auto-generated constructor stub
	}		
	public ProductCount(int id, int logo_id, String name, String category_name, double sumCount, int is_promotion,
			double unit_price, double promotion_price, double quantity, double sumIsLottery) {
		super();
		this.id = id;
		this.logo_id = logo_id;
		this.name = name;
		this.category_name = category_name;
		this.sumCount = sumCount;
		this.is_promotion = is_promotion;
		this.unit_price = unit_price;
		this.promotion_price = promotion_price;
		this.quantity = quantity;
		this.sumIsLottery = sumIsLottery;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLogo_id() {
		return logo_id;
	}

	public void setLogo_id(int logo_id) {
		this.logo_id = logo_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public double getSumCount() {
		return sumCount;
	}

	public void setSumCount(double sumCount) {
		this.sumCount = sumCount;
	}

	public int getIs_promotion() {
		return is_promotion;
	}

	public void setIs_promotion(int is_promotion) {
		this.is_promotion = is_promotion;	
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public double getPromotion_price() {
		return promotion_price;
	}

	public void setPromotion_price(double promotion_price) {
		this.promotion_price = promotion_price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getSumIsLottery() {
		return sumIsLottery;
	}

	public void setSumIsLottery(double sumIsLottery) {
		this.sumIsLottery = sumIsLottery;
	}

	@Override
	public String toString() {
		return "ProductCount [id=" + id + ", logo_id=" + logo_id + ", name=" + name + ", category_name=" + category_name
				+ ", sumCount=" + sumCount + ", is_promotion=" + is_promotion + ", unit_price=" + unit_price
				+ ", promotion_price=" + promotion_price + ", quantity=" + quantity + ", sumIsLottery=" + sumIsLottery
				+ "]";
	}
		
}
