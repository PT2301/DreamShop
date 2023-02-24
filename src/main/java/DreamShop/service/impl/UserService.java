package DreamShop.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import DreamShop.converter.RoleConverter;
import DreamShop.converter.UserConverter;
import DreamShop.dto.MyUser;
import DreamShop.dto.RoleDTO;
import DreamShop.dto.UserDTO;
import DreamShop.entity.UserEntity;
import DreamShop.repository.RoleRepository;
import DreamShop.repository.UserRepository;
import DreamShop.service.IUserService;
@Service
public  class UserService implements IUserService {
	@Autowired
	private BCryptPasswordEncoder BCrypt;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private RoleConverter roleConverter;
	@Override
	public UserDTO save(UserDTO user) {	
		user.setPassword(BCrypt.encode(user.getPassword()));
		List<RoleDTO> roles=new ArrayList<>();
		roles.add(roleConverter.toDto(roleRepository.findById(2)));
		user.setRoles(roles);
		return userConverter.toDto(userRepository.save(userConverter.toEntity(user)));
		
	}
	@Override
	public UserDTO checkUser(UserDTO user) {	
		UserEntity entity=userRepository.findOneByEmail(user.getEmail());
		if(entity!=null) {
			return userConverter.toDto(entity);
		}
		entity=userRepository.findOneByUsername(user.getUsername());
		if(entity!=null) {
			return userConverter.toDto(entity);	
		}
		return null;
	}
	@Override
	public UserDTO findOneByEmailAndUsername(String email, String username) {	
		UserEntity user=userRepository.findOneByEmailAndUsername(email, username);
		if(user==null) {
			return null;
		}
		return userConverter.toDto(user);
	}
	@Override
	public void delete(MyUser myUser) {
		UserEntity e=userRepository.findOneByEmail(myUser.getEmail());
		userRepository.delete(e);
		
	}

}
