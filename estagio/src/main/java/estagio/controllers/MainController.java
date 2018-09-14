package estagio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String listing() {
		return "index";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}
	
	@GetMapping("/update...")
	public String edit() {
		return "insert";
	}
	
	@GetMapping("/login")
	public String login() {
		return "index";
	}

}
