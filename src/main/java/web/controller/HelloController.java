package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private UserService userService;


	/*@PostMapping("/add")
	public String userList(User user, Role role) {

		userService.add(user);
		return "redirect:/admin";
	}*/



	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		List<User> messages = userService.getUser();
		model.addAttribute("messages", messages);
		return "hello";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String printLogin(ModelMap model) {
	//	List<User> messages = userService.getUser();
	//	model.addAttribute("messages", messages);
		return "login";
	}






	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String printAdd(ModelMap model) {
		model.addAttribute("name");
		return "registration";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String printAddPost(User user) {
		userService.add(user);
		return "redirect:/admin";

	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String printEdit(Model model, User user) {
		model.addAttribute("user", user);
		return "edit";

	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String printEditPost(User user) {
		userService.update(user);
		return "redirect:/hello";

	}

	@RequestMapping(value = "del", method = RequestMethod.GET)
	public String printDel(User user) {
		userService.delete(user.getId());
		return "redirect:/hello";

	}





	
}