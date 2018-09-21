package estagio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("hidden_attribute", "hidden");
		return mv;
	}

}
