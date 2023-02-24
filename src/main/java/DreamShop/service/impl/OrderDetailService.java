package DreamShop.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DreamShop.converter.OrderDetailConverter;
import DreamShop.dto.ItemDTO;
import DreamShop.dto.OrderDTO;
import DreamShop.dto.OrderDetailDTO;
import DreamShop.repository.OrderDetailRepository;
import DreamShop.service.IOrderDetailService;
@Service
public class OrderDetailService implements IOrderDetailService{
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private OrderDetailConverter orderDetailConverter;
	@Override
	public void insert(HashMap<Long, ItemDTO> cart, OrderDTO order) {
		OrderDetailDTO detail=new OrderDetailDTO();
		for (Map.Entry<Long, ItemDTO> item : cart.entrySet()) {
			detail.setOrder_id(order.getId());
			detail.setProduct_id(item.getValue().getProduct().getId());
			detail.setQuantity(item.getValue().getQuantity());
			detail.setTotalMoney(item.getValue().getTotalPrice());
			orderDetailConverter.toDto(orderDetailRepository.save(orderDetailConverter.toEntity(detail)));
		 }
		

	}

}
