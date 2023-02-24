package DreamShop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntity extends BaseEntity{
	@Column(name = "name",columnDefinition="text")
	private String name;
	@Column(name = "size")
	private String size;
	@Column(name = "price")
	private double price;
	@Column(name = "quantity")
	private long quantity;
	@Column(name = "detail",columnDefinition="text")
	private String detail;
	@Column(name = "status")
    private long status;
	@Column(name = "highlight")
	private int highlight;
	@Column(name = "newProduct")
	private int newProduct;
	@Column(name = "sale")
	private int sale;
	@Column(name = "img", columnDefinition = "text")
	private String img;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name = "product_color",
		       joinColumns = @JoinColumn(name = "product_id"),
		       inverseJoinColumns = @JoinColumn(name = "color_id"))
	private List<ColorEntity> colors = new ArrayList<>();
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	private List<OrderDetailEntity> OrderDetail= new ArrayList<>();

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

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public List<ColorEntity> getColors() {
		return colors;
	}

	public void setColors(List<ColorEntity> colors) {
		this.colors = colors;
	}

	public List<OrderDetailEntity> getOrderDetail() {
		return OrderDetail;
	}

	public void setOrderDetail(List<OrderDetailEntity> orderDetail) {
		OrderDetail = orderDetail;
	}

	
	
	

}
