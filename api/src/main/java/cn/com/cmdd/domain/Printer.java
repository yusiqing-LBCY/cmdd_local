package cn.com.cmdd.domain;



import org.apache.ibatis.type.Alias;

@Alias("Printer")
public class Printer {
	private Integer id;
	private Integer shop_id;
	private Integer printer_type;
	//打印机名称
	private String name;
	/*
	 * 菜品类别名、特殊单据
	 * 用处：列表展示页面，编辑页面 打印类型名称
	 */
	private String category_name;
	private Integer page_width;
		
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
	public Integer getPrinter_type() {
		return printer_type;
	}
	public void setPrinter_type(Integer printer_type) {
		this.printer_type = printer_type;
		if(printer_type==888){
			this.category_name="后厨";
		}else if(printer_type==999){
			this.category_name="结账单";
		}
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
	public void setCategory_name(String category_name){
		this.category_name = category_name;
	}
	public Integer getPage_width() {
		return page_width;
	}
	public void setPage_width(Integer page_width) {
		this.page_width = page_width;
	}		
}
