package DreamShop.service;

import java.util.HashMap;

import DreamShop.dto.ItemDTO;
import DreamShop.dto.OrderDTO;

public interface IOrderDetailService {	
	void insert(HashMap<Long, ItemDTO> cart,OrderDTO order );
}
