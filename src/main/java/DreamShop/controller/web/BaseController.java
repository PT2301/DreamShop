package DreamShop.controller.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import DreamShop.service.ICategoryService;
import DreamShop.service.IMenuService;
import DreamShop.utill.SecurityUtill;

@Controller
public class BaseController {
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	public IMenuService menuService;
	public ModelAndView mvShare = new ModelAndView();
	@PostConstruct
	public ModelAndView Init () {
		mvShare.addObject("menus", menuService.findAll());
		mvShare.addObject("categories",categoryService.findAll());
		//lấy thông tin user đang login
//		if(SecurityUtill!=null) {
//			mvShare.addObject("myUser",SecurityUtill.getPrincipal());
//		}	
		return mvShare;
	}
}
