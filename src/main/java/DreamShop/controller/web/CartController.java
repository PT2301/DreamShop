package DreamShop.controller.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DreamShop.dto.ItemDTO;
import DreamShop.service.ICartService;
import DreamShop.utill.SessionUtill;

@Controller
public class CartController extends BaseController {
	@Autowired
	private ICartService cartService ;
	
	@RequestMapping(value = "/cart")
	public ModelAndView Cart(HttpSession session) {
		
		HashMap<Long, ItemDTO> cart = (HashMap<Long, ItemDTO>)SessionUtill.getInstance().getValue(session, "cart");
		if(cart == null) {
			cart = new HashMap<Long, ItemDTO>();
		}
		SessionUtill.getInstance().getValue(session, "cart");
		SessionUtill.getInstance().putValue(session, "TotalProduct",cartService.totalQuantity(cart));
		SessionUtill.getInstance().putValue(session, "TotalMoney",cartService.totalMoney(cart));
		mvShare.setViewName("web/cart");
		return mvShare;
	
	}
	@RequestMapping(value = "/addCart/{id}")
	public String AddCart(HttpServletRequest request ,HttpSession session, @PathVariable long id,
			@RequestParam(value="quantity",required=false) Long quantity) {
		HashMap<Long, ItemDTO> cart = (HashMap<Long, ItemDTO>)SessionUtill.getInstance().getValue(session, "cart");
		if(cart == null) {
			cart = new HashMap<Long, ItemDTO>();
		}
		if(quantity==null||cart.get(id)==null) {
			if(quantity==null) {
				quantity=1l;
			}
			cart = cartService.addCart(id,quantity, cart);
		}else {
			cart = cartService.editCart(id,quantity, cart);
		}
		
		SessionUtill.getInstance().putValue(session, "cart",cart);
		SessionUtill.getInstance().putValue(session, "TotalProduct",cartService.totalQuantity(cart));
		SessionUtill.getInstance().putValue(session, "TotalMoney",cartService.totalMoney(cart));
		return "redirect:"+request.getHeader("Referer");
	

	}
	@RequestMapping(value = "/deleteCart/{id}")
	public ModelAndView deleteCart(HttpSession session,@PathVariable long id) {		
		HashMap<Long, ItemDTO> cart = (HashMap<Long, ItemDTO>)SessionUtill.getInstance().getValue(session, "cart");
		if(cart == null) {
			cart = new HashMap<Long, ItemDTO>();
		}
		cart=cartService.deleteCart(id, cart);
		SessionUtill.getInstance().putValue(session, "cart",cart);
		SessionUtill.getInstance().putValue(session, "TotalProduct",cartService.totalQuantity(cart));
		SessionUtill.getInstance().putValue(session, "TotalMoney",cartService.totalMoney(cart));
		mvShare.setViewName("web/cart");
		return mvShare;
	
	}
	@RequestMapping(value = "/editCart/{id}")
	public ModelAndView editCart(HttpSession session,@PathVariable long id) {
		
		HashMap<Long, ItemDTO> cart = (HashMap<Long, ItemDTO>)SessionUtill.getInstance().getValue(session, "cart");
		if(cart == null) {
			cart = new HashMap<Long, ItemDTO>();
		}
		ItemDTO cartDto=cart.get(id);
		mvShare.addObject("product", cartDto.getProduct());
		mvShare.addObject("quantity", cartDto.getQuantity());
		mvShare.setViewName("web/product/product_detail");
		return mvShare;
	
	}
	
}
