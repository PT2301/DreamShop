package DreamShop.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DreamShop.dto.ItemDTO;
import DreamShop.dto.ProductDTO;
import DreamShop.service.ICartService;
import DreamShop.service.IProductService;

@Service
public class CartService implements ICartService {
	@Autowired
	private IProductService productService;

	@Override
	public HashMap<Long, ItemDTO> addCart(Long id,long quantity, HashMap<Long, ItemDTO> cart) {
		ItemDTO itemCart = new ItemDTO();
		ProductDTO product = productService.findById(id);
		if (product != null&& cart.containsKey(id)) {
			itemCart=cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity()+quantity);
			itemCart.setTotalPrice(itemCart.getProduct().getPrice() * itemCart.getQuantity());
		}else {
			itemCart.setProduct(product);
			itemCart.setQuantity(quantity);
			itemCart.setTotalPrice(product.getPrice() * itemCart.getQuantity());
		}
		cart.put(id, itemCart);
		return cart;
	}

	@Override
	public HashMap<Long, ItemDTO> editCart(Long id, long quantity, HashMap<Long, ItemDTO> cart) {
		if (cart == null) {
			return cart;
		}
		ItemDTO itemCart = new ItemDTO();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			itemCart.setTotalPrice(itemCart.getProduct().getPrice() * quantity);
		}
		cart.put(id, itemCart);
		return cart;
	}

	@Override
	public HashMap<Long, ItemDTO> deleteCart(Long id, HashMap<Long, ItemDTO> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}
	@Override
	public long totalQuantity(HashMap<Long, ItemDTO> cart) {
		long totalQuantity=0;
		for(Map.Entry<Long, ItemDTO> itemCart:cart.entrySet()) {
			 totalQuantity+=itemCart.getValue().getQuantity();
		}
		return totalQuantity;
	}
	@Override
	public double totalMoney(HashMap<Long, ItemDTO> cart) {
		double totalMoney=0;
		for(Map.Entry<Long, ItemDTO> itemCart:cart.entrySet()) {
			totalMoney+=itemCart.getValue().getTotalPrice();
		}
		return totalMoney;
	}
}
