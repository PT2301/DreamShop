package DreamShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DreamShop.entity.OrderEntity;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
	OrderEntity findOneById(long id);

}
