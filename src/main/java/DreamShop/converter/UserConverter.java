package DreamShop.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DreamShop.dto.RoleDTO;
import DreamShop.dto.UserDTO;
import DreamShop.entity.RoleEntity;
import DreamShop.entity.UserEntity;

@Component
public class UserConverter {
	@Autowired
	private RoleConverter roleConverter;
	public UserEntity toEntity(UserDTO dto) {
		UserEntity e =new UserEntity();
		e.setEmail(dto.getEmail());
		e.setPassword(dto.getPassword());
		e.setUsername(dto.getUsername());
		e.setStatus(1);		
		if(dto.getRoles()!=null) {
			List<RoleEntity> list=new ArrayList<>();
			for(RoleDTO role:dto.getRoles()) {
				list.add(roleConverter.toEntity(role));
			}
			e.setRoles(list);
		}
		
		return e;	
	}
	public UserDTO toDto(UserEntity e) {
		UserDTO dto=new UserDTO();
		dto.setEmail(e.getEmail());
		dto.setId(e.getId());
		dto.setPassword(e.getPassword());
		dto.setStatus(e.getStatus());
		dto.setUsername(e.getUsername());
		if(e.getRoles()!=null) {
			List<RoleDTO> list=new ArrayList<>();
			for(RoleEntity role:e.getRoles()) {
				list.add(roleConverter.toDto(role));
			}
			dto.setRoles(list);
		}
		
		return dto;
		
	}

}
