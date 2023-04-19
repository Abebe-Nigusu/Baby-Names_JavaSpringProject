package com.abebe.babybames.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.abebe.babybames.models.LoginUser;
import com.abebe.babybames.models.User;
import com.abebe.babybames.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
//@RequestMapping("/users")
public class UserController {

	private final UserService userServ;
	public UserController(UserService userServ) {
		this.userServ = userServ;
	}
	
	@GetMapping("/")
	public String loginReg(@ModelAttribute("newUser") User user, @ModelAttribute("loginUser") LoginUser loginUser) {
		return "user/loginReg.jsp";
	}
	
	@PostMapping("/users/process/register")
	public String processRegisterUser(@Valid @ModelAttribute("newUser") User user,BindingResult result, Model model, HttpSession session) {
		// to-do - Reject values
		// reject if the password doesn't match
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("password", "Match", "confirm password must match password");
		}
		// reject if the email is taken
		if(userServ.getUser(user.getEmail()) != null) {
			result.rejectValue("email", "Unique", "email is already in use!");
		}
		// re-render if errors
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "user/loginReg.jsp";
		}
		User newUser = userServ.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/";
	}
	
	@PostMapping("/users/process/login")
	public String processLoginUser(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		User loggingUser = userServ.login(loginUser,result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "user/loginReg.jsp";
		}
		session.setAttribute("user_id", loggingUser.getId());
		return "redirect:/home";
	}
	
	@GetMapping("/users/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
