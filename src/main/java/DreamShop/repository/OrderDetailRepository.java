package DreamShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DreamShop.entity.OrderDetailEntity;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Long>{

}
