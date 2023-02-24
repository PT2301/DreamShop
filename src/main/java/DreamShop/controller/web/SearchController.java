package DreamShop.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DreamShop.constant.SystemConstant;
import DreamShop.dto.ProductDTO;
import DreamShop.paging.IPaginateService;
import DreamShop.service.IProductService;

@Controller
public class SearchController extends BaseController{
	@Autowired
	private IProductService  productService;
	@Autowired
	private IPaginateService paginateService;
	@RequestMapping(value = {"/search"}, method = RequestMethod.GET)
	public ModelAndView Search(@RequestParam(value = "key", required = false) String key,@RequestParam(value="currentPage",defaultValue = "1" ) Long currentPage) {
		mvShare.setViewName("web/product/search_product");
		mvShare.addObject("key",key);
		mvShare.addObject("productInPage",productService.ProductInPage(key, currentPage));
		List<ProductDTO> allProductById = productService.findByKey(key);
		mvShare.addObject("paginate",paginateService.GetInfoPaginate(allProductById.size(), SystemConstant.ProductInPage, currentPage));
		return mvShare;
		
	}

}
