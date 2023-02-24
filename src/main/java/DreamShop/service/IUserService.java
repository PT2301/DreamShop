package DreamShop.service;

import DreamShop.dto.MyUser;
import DreamShop.dto.UserDTO;


public interface IUserService {
	UserDTO save(UserDTO user);
	UserDTO findOneByEmailAndUsername(String email,String username);
	UserDTO checkUser(UserDTO user);
	void delete(MyUser myUser);
	

}
