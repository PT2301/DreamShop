package DreamShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DreamShop.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
	UserEntity findOneByEmailAndStatus(String email,long status);
	UserEntity findOneByEmailAndUsername(String email,String username);
	UserEntity findOneByEmail(String email);
	UserEntity findOneByUsername(String username);
	

}
