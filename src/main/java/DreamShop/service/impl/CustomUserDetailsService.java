package DreamShop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import DreamShop.constant.SystemConstant;
import DreamShop.dto.MyUser;
import DreamShop.entity.RoleEntity;
import DreamShop.entity.UserEntity;
import DreamShop.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity entity=userRepository.findOneByEmailAndStatus(email, SystemConstant.ACTION_STATIC);
		if(entity==null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities=new ArrayList<>();
		for(RoleEntity role: entity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}		
		//put thong tin vaop scurity de duy trong trong suot qua trong dang nhap
		 MyUser myUser=new MyUser(entity.getUsername(), entity.getPassword(), true, true, true, true, authorities);
		 myUser.setEmail(entity.getEmail());
		return myUser;//giu thong tin ng dung
	}
	

}
