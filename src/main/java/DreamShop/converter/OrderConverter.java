package DreamShop.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DreamShop.dto.OrderDTO;
import DreamShop.entity.OrderEntity;
import DreamShop.service.IStatusOrderService;
@Component
public class OrderConverter {
	@Autowired
	private IStatusOrderService statusOrderService;
	public OrderDTO toDto(OrderEntity e) {
		OrderDTO d=new OrderDTO();
		d.setId(e.getId());
		d.setAddress(e.getAddress());
		d.setPhone(e.getPhone());
		d.setUsername(e.getUsername());
		d.setNote(e.getNote());
		d.setQuantity(e.getQuantity());
		d.setTotalMoney(e.getTotalMoney());
		if(e.getStatus()!=null) {
			d.setStatus_id(e.getStatus().getId());
		}else {
			d.setStatus_id(1);
		}
		
		return d ;		
	}

	public OrderEntity toEntity(OrderDTO d) {
		OrderEntity e = new OrderEntity();
		if(d.getId()!=0) {
			e.setId(d.getId());
		}
		e.setAddress(d.getAddress());
		e.setPhone(d.getPhone());
		e.setUsername(d.getUsername());
		e.setNote(d.getNote());
		e.setQuantity(d.getQuantity());
		e.setTotalMoney(d.getTotalMoney());
		e.setStatus(statusOrderService.findById(d.getStatus_id()));
		return e;
	}
	
	
}
