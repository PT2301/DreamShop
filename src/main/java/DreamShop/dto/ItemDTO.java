package DreamShop.dto;

public class ItemDTO {
	private ProductDTO product;
	private long quantity;
	private double totalPrice;

	public ItemDTO(ProductDTO product, long quantity, double totalPrice) {
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;

	}

	public ItemDTO() {
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
