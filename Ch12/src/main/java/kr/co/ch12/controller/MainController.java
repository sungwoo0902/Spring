package kr.co.ch12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value = {"/", "/index"})
	private String index() {
		return "/index";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
}
