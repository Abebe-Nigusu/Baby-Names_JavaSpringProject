package com.abebe.babybames.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abebe.babybames.models.BabyName;
import com.abebe.babybames.services.BabyNameService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/babyNames")
public class BabyNameController {

	@Autowired
	private BabyNameService babyNameServ;

	@GetMapping("/new")
	public String createBabyName(@ModelAttribute("babyName") BabyName babyName,HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/reg";
		}
		return "babyName/create.jsp";
	}
	
	@PostMapping("/process/new")
	public String processCreateBabyName(@Valid @ModelAttribute("babyName") BabyName babyName, BindingResult result) {
		if(babyNameServ.getBabyName(babyName.getName()) != null) {
			result.rejectValue("name", "Unique", "name is already in use!");
		}
		if(result.hasErrors()) {
			return "babyName/create.jsp";
			
		}
		babyNameServ.create(babyName);
		return "redirect:/home";
		
	}
	
	@GetMapping("/display/{id}")
	public String diplayBabyName(@PathVariable("id") Long id, Model model) {
		model.addAttribute("babyName", babyNameServ.getOne(id));
		return "babyName/display.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String editBabyName(Model model, @PathVariable("id") Long id) {
		model.addAttribute("babyName", babyNameServ.getOne(id));
		return "babyName/edit.jsp";
	}
	
	@PutMapping("/process/edit/{id}")
	public String processEditBabyName(@Valid @ModelAttribute("babyName") BabyName babyName, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "babyName/edit.jsp";
		}
		babyNameServ.update(babyName);
		return "redirect:/home";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBabyName(@PathVariable("id") Long id) {
		babyNameServ.delete(id);
		return "redirect:/home";
	}

}
