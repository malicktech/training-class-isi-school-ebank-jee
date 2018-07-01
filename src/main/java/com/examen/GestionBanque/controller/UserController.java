package com.examen.GestionBanque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.GestionBanque.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping({ "/liste" })
	public String getUserList(Model model) {
		model.addAttribute("users", userService.findAll());
		return "user/liste";
	}

}
