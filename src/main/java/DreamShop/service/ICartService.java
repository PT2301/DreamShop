package DreamShop.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DreamShop.dto.ItemDTO;

@Service
public interface ICartService {
	HashMap<Long,ItemDTO> addCart(Long id,long quantity,HashMap<Long,ItemDTO> cart);
	HashMap<Long,ItemDTO> editCart(Long id,long quantity,HashMap<Long,ItemDTO> cart);
	HashMap<Long,ItemDTO> deleteCart(Long id,HashMap<Long,ItemDTO> cart);
	double totalMoney(HashMap<Long, ItemDTO> cart);
	long totalQuantity(HashMap<Long, ItemDTO> cart);

}