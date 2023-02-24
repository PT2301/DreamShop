package DreamShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DreamShop.entity.StatusOrderEntity;
import DreamShop.repository.StatusOrderRepository;
import DreamShop.service.IStatusOrderService;
@Service
public class StatusOrderService implements IStatusOrderService{
	@Autowired
	private StatusOrderRepository statusOrderRepository;
	@Override
	public StatusOrderEntity findById(long id) {
		StatusOrderEntity a=statusOrderRepository.findById(id);
		return a;
	}

}
