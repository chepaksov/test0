package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "hello";
	}


	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String printAdd(ModelMap model) {
		ModelAndView result = new ModelAndView("/add");
		result.addObject("mans", new User());
		model.addAttribute("name");
		return "registration";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String printAddPost(ModelMap model) {

		String manName = (String) model.get("name");
		return "redirect:/hello";
	}




	
}