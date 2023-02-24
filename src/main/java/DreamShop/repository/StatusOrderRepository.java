package DreamShop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DreamShop.entity.StatusOrderEntity;

@Repository
public interface StatusOrderRepository extends JpaRepository<StatusOrderEntity,Long> {
	 StatusOrderEntity findById(long id);
	

}
