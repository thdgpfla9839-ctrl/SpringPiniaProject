package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 여기는 화면만 변경해주는 역할이야
@Controller
public class RecipeController {

	@GetMapping("/recipe/list")
	public String recipe_list()
	{
		return "recipe/list";
	}
	
	@GetMapping("/recipe/detail")
	public String redcipe_detail(@RequestParam("no") int no, Model model)
	{
		model.addAttribute("no",no);
		return "recipe/detail";
	}
}
