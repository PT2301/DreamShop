package DreamShop.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DreamShop.dto.OrderDetailDTO;
import DreamShop.entity.OrderDetailEntity;
import DreamShop.service.IOrderService;
import DreamShop.service.IProductService;
@Component
public class OrderDetailConverter {
	@Autowired
	private IProductService productService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private ProductConverter productConcerter;
	@Autowired
	private OrderConverter  orderConverter;
	public OrderDetailDTO toDto(OrderDetailEntity e) {
		OrderDetailDTO d=new OrderDetailDTO();
		d.setId(e.getId());
		d.setOrder_id(e.getOorder().getId());
		d.setProduct_id(e.getProduct().getId());
		d.setQuantity(e.getQuantity());
		d.setTotalMoney(e.getTotalMoney());
		return d;
	}
	public OrderDetailEntity toEntity(OrderDetailDTO d) {
		OrderDetailEntity e=new OrderDetailEntity();
		if(d.getId()!=0) {
			e.setId(d.getId());
		}
		e.setOorder(orderConverter.toEntity(orderService.findOneById(d.getOrder_id())));
		e.setProduct(productConcerter.toEntity(productService.findById(d.getProduct_id())));
		e.setQuantity(d.getQuantity());
		e.setTotalMoney(d.getTotalMoney());
		return e;
	}

}
