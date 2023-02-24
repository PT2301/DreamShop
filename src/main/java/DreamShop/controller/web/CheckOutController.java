package DreamShop.controller.web;
import java.util.HashMap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import DreamShop.dto.ItemDTO;
import DreamShop.dto.OrderDTO;
import DreamShop.service.IOrderDetailService;
import DreamShop.service.IOrderService;
import DreamShop.utill.SecurityUtill;
import DreamShop.utill.SessionUtill;

@Controller(value="checkOut")
public class CheckOutController extends BaseController{
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IOrderDetailService orderDetailService;
	@RequestMapping(value="/checkout",method = RequestMethod.GET)
	public ModelAndView checkOut() {
		mvShare.setViewName("web/order/checkout");
		mvShare.addObject("order",new OrderDTO());
		mvShare.addObject("myUser",SecurityUtill.getPrincipal());
		return mvShare;
	}
	@RequestMapping(value="/checkout",method = RequestMethod.POST)
	public ModelAndView Order(@ModelAttribute("order")OrderDTO order,HttpSession session ) {
		mvShare.setViewName("web/order/checkout");
		mvShare.addObject("myUser",SecurityUtill.getPrincipal());
		order.setQuantity((long)SessionUtill.getInstance().getValue(session, "TotalProduct"));
		order.setTotalMoney((double)SessionUtill.getInstance().getValue(session, "TotalMoney"));
		order.setStatus_id(1);
		OrderDTO oorder=orderService.insert(order);
		
		HashMap<Long, ItemDTO> cart = (HashMap<Long, ItemDTO>)SessionUtill.getInstance().getValue(session, "cart");
		orderDetailService.insert(cart, oorder);
		mvShare.addObject("order",oorder);
		return mvShare;
	}
	@RequestMapping(value="/listOrder", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") long page, 
								 @RequestParam("limit") long limit,HttpServletRequest rq) {
		OrderDTO model = new OrderDTO();
		model.setPage(page);
		model.setLimit(limit);
		mvShare.setViewName("web/order/listOrder");
		Pageable pageable = new PageRequest((int)page - 1,(int)limit);
		model.setListResult(orderService.findAll(pageable));
		model.setTotalProduct(orderService.getTotalOrder());
		model.setTotalPage((long)Math.ceil((double) model.getTotalProduct() / model.getLimit()));
		mvShare.addObject("model", model);
		return mvShare;	
	}
	

}
