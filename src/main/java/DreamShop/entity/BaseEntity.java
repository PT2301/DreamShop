package DreamShop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="createdate")
	@CreatedDate
	private Date createDate;
	
	@Column(name="modifieddate")
	@LastModifiedDate
	private Date modifiedDate;
	
	@Column(name="createby")
	@CreatedBy
	private String createBY;
	
	@Column(name="modifiedby")
	@LastModifiedBy
	private String modifiedBy;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public void setCreateBY(String createBY) {
		this.createBY = createBY;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public String getCreateBY() {
		return createBY;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
}
