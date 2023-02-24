package DreamShop.dto;

import java.util.List;

public class UserDTO extends AbstractDTO<UserDTO> {
	private String email;
	private String username;
	private String password;
	private long status;
	private List<RoleDTO> roles ;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public List<RoleDTO> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	
	

}
