package com.examen.GestionBanque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.GestionBanque.entities.User;
import com.examen.GestionBanque.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping({ "/liste" })
	public String getUserList(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user/liste";
	}

}
