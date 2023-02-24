package DreamShop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import DreamShop.dto.OrderDTO;
@Service
public interface IOrderService {
	OrderDTO findOneById(long id);
	OrderDTO insert(OrderDTO order);
	List<OrderDTO> findAll(Pageable pageable);
	long getTotalOrder();
	

}
