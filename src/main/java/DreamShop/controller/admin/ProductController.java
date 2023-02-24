package DreamShop.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DreamShop.dto.CategoryDTO;
import DreamShop.dto.ProductDTO;
import DreamShop.service.ICategoryService;
import DreamShop.service.IProductService;
import DreamShop.utill.MessageUtil;


@Controller  (value="productControllerOfAdmin")
public class ProductController {
	@Autowired
	private IProductService productService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired 
	private MessageUtil messageUtil;
	@RequestMapping(value = "/admin/product/list", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") long page, 
								 @RequestParam("limit") long limit,HttpServletRequest rq) {
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/product/list");
		Pageable pageable = new PageRequest((int)page - 1,(int)limit);
		model.setListResult(productService.findAll(pageable));
		model.setTotalProduct(productService.getTotalProduct());
		model.setTotalPage((long)Math.ceil((double) model.getTotalProduct() / model.getLimit()));
		if(rq.getParameter("message")!=null) {
			Map<String,String> message=messageUtil.getMessage(rq.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;	
	}
	
	@RequestMapping(value = "admin/product/edit", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value="id",required=false) Long id, HttpServletRequest rq) {
		ModelAndView mav = new ModelAndView("admin/product/edit");
		ProductDTO model=new ProductDTO();
		if(id!=null) {
		model=productService.findById(id);	
		}
		if(rq.getParameter("message")!=null) {
			Map<String,String> message=messageUtil.getMessage(rq.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		Map<Long,String> result=new HashMap<>();
		List<CategoryDTO> entities=categoryService.findAll();
		for (CategoryDTO item: entities) {
			result.put(item.getId(), item.getName());
		}
		mav.addObject("categories",result);
		mav.addObject("model", model);
		return mav;
	}
}
