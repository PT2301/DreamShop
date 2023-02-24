package DreamShop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import DreamShop.converter.OrderConverter;
import DreamShop.dto.OrderDTO;
import DreamShop.entity.OrderEntity;
import DreamShop.repository.OrderRepository;
import DreamShop.service.IOrderService;
@Service
public class OrderService implements IOrderService{
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderConverter orderConverter;
	@Override
	public OrderDTO insert(OrderDTO order) {			
		return orderConverter.toDto(orderRepository.save(orderConverter.toEntity(order)));
	}
	@Override
	public OrderDTO findOneById(long id) {	
		return orderConverter.toDto(orderRepository.findOneById(id));
	}
	@Override
	public List<OrderDTO> findAll(Pageable pageable) {
		List<OrderDTO> list=new ArrayList<>();
		List<OrderEntity> entity=orderRepository.findAll(pageable).getContent();
		for(OrderEntity item:entity) {
			list.add(orderConverter.toDto(item));
		}
		return list;
	}
	@Override
	public long getTotalOrder() {		
		return orderRepository.count();
	}
	
	
	
	

}
