package DreamShop.dto;

import java.util.List;

public class ProductDTO extends AbstractDTO<ProductDTO> {
	private String name;
	private String size;
	private double price;
	private long quantity;
	private String detail;
    private long status;	
	private int highlight;	
	private int newProduct;	
	private int sale;	
	private String img;
	private Long categoryId;
	private String categoryCode;
	private List<ColorDTO> color;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public int getHighlight() {
		return highlight;
	}
	public void setHighlight(int highlight) {
		this.highlight = highlight;
	}
	public int getNewProduct() {
		return newProduct;
	}
	public void setNewProduct(int newProduct) {
		this.newProduct = newProduct;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public List<ColorDTO> getColor() {
		return color;
	}
	public void setColor(List<ColorDTO> color) {
		this.color = color;
	}
	
	
	
	
	

}
