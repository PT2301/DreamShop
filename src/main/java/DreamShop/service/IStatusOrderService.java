package DreamShop.service;

import org.springframework.stereotype.Service;

import DreamShop.entity.StatusOrderEntity;
@Service
public interface IStatusOrderService {
		StatusOrderEntity findById(long id);
}
