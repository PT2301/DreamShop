package DreamShop.converter;

import org.springframework.stereotype.Component;

import DreamShop.dto.RoleDTO;
import DreamShop.entity.RoleEntity;
@Component
public class RoleConverter {
	public RoleEntity toEntity(RoleDTO dto) {
		RoleEntity e=new RoleEntity();
		e.setId(dto.getId());;
		e.setCode(dto.getCode());
		e.setName(dto.getName());
//		if(dto.getUsers()!=null) {
//			List<UserEntity> list=new ArrayList<>();
//			for(UserDTO user:dto.getUsers()) {
//				list.add(userConverter.toEntity(user));
//				
//			}
//			e.setUsers(list);
//		}
		
		return e;
	}
	public RoleDTO toDto(RoleEntity e) {
		RoleDTO dto=new RoleDTO();
		dto.setId(e.getId());
		dto.setCode(e.getCode());
		dto.setName(e.getName());
//		if(e.getUsers()!=null) {
//			List<UserDTO> list=new ArrayList<>();
//			for(UserEntity user:e.getUsers()) {
//				list.add(userConverter.toDto(user));
//			}
//			dto.setUsers(list);
//		}
		
		return dto;
	}

}
