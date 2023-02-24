package DreamShop.dto;

public class OrderDTO extends AbstractDTO<OrderDTO> {
	private String username;
	private String address;
	private String phone;
	private String note;
	private double totalMoney;
	private long quantity;
	private long status_id;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getStatus_id() {
		return status_id;
	}
	public void setStatus_id(long status_id) {
		this.status_id = status_id;
	}
	
	
	
}
