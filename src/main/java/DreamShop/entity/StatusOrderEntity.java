package DreamShop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="statusorder")
public class StatusOrderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="code")
	private String code;
	
	@OneToMany(mappedBy="status",cascade=CascadeType.ALL)
	private List<OrderEntity> oorder;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<OrderEntity> getOorder() {
		return oorder;
	}
	public void setOorder(List<OrderEntity> oorder) {
		this.oorder = oorder;
	}
	
	
	

}
