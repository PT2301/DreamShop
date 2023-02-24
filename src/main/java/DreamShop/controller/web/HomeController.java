package DreamShop.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DreamShop.dto.UserDTO;
import DreamShop.service.IProductService;
import DreamShop.service.ISlidesService;
import DreamShop.service.impl.UserService;
import DreamShop.utill.SecurityUtill;

@Controller(value = "homeControllerOfWeb")
public class HomeController extends BaseController {
	@Autowired
	private ISlidesService slidesService;	
	@Autowired
	private IProductService productService;
	@Autowired
	private UserService  userService;
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public ModelAndView homePage() {
	    mvShare.addObject("slides",slidesService.findAll());
	    mvShare.addObject("products",productService.findAll());
	    mvShare.addObject("highlight",productService.findByHighLight());
	    mvShare.addObject("myUser",SecurityUtill.getPrincipal());
	    mvShare.setViewName("web/home");
		return mvShare;
	}
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public ModelAndView LoginPage(@RequestParam(value="message",required=false) String massage) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		mv.addObject("message", massage);
		return mv;
	}
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView("redirect:/home");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return mv;
	}
	@RequestMapping(value = {"/accessDenied"}, method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/login?accessDenied");
		return mv;
	}	
	@RequestMapping(value = {"/create"}, method = RequestMethod.GET)
	public ModelAndView createAccount(@RequestParam(value="message",required=false) String massage) {
		ModelAndView mv=new ModelAndView("createUser");
		mv.addObject("user", new UserDTO());
		mv.addObject("message", massage);
		return mv;
	}
	@RequestMapping(value = {"/createAccount"}, method = RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("user")UserDTO user) {		
		ModelAndView mv=new ModelAndView();
		if(userService.checkUser(user)!=null) {
			mv.setViewName("redirect:/create?message=Email or Username already exist");
		}else{
			userService.save(user);
			mv.setViewName("redirect:/login?message=Create success");
		}
		return mv;
	}
	@RequestMapping(value = {"/deleteAccount"}, method = RequestMethod.GET)
	public ModelAndView deleteAcount(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView("redirect:/home");
		userService.delete(SecurityUtill.getPrincipal());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return mv;
	}
	
}
