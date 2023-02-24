package DreamShop.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DreamShop.constant.SystemConstant;
import DreamShop.dto.ProductDTO;
import DreamShop.paging.IPaginateService;
import DreamShop.service.IProductService;
@Controller(value = "ProductControllerOfWeb")
public class ProductController extends BaseController{
	@Autowired
	private IProductService productService;
	@Autowired
	private IPaginateService paginateService;
	
	@RequestMapping(value = {"/product/{category_id}/{currentPage}"}, method = RequestMethod.GET)
	public ModelAndView product(@PathVariable Long category_id,@PathVariable Long currentPage) {
		mvShare.setViewName("web/product/category");
		mvShare.addObject("idCategory",category_id);
		mvShare.addObject("productInPage",productService.ProductInPage(category_id, currentPage));
		List<ProductDTO> allProductById = productService.findByCategory(category_id);
		mvShare.addObject("paginate",paginateService.GetInfoPaginate(allProductById.size(), SystemConstant.ProductInPage, currentPage));
		return mvShare;
	}
	@RequestMapping(value = {"/product-detail/{id}"}, method = RequestMethod.GET)
	public ModelAndView product_detail(@PathVariable Long id) {
		mvShare.setViewName("web/product/product_detail");
		mvShare.addObject("product",productService.findById(id));
		List<ProductDTO> allProductById = productService.findByCategory(productService.findById(id).getCategoryId());
		mvShare.addObject("allProductById",allProductById);
		return mvShare;
	}
		


}
