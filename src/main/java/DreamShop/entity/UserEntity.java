package DreamShop.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class UserEntity extends BaseEntity {
	
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="username")
	private String username;
	@Column(name="status")
	private long status;
	
	@ManyToMany( fetch=FetchType.LAZY)
	@JoinTable(name = "user_role",
		       joinColumns = @JoinColumn(name = "user_id"),
		       inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles ;
	
	
	public List<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	
	
	
}
