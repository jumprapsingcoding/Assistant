package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Assistant;
import com.example.demo.repository.AssistantRepository;

@Controller
public class AssistantController {
	
	@Autowired
	// private JdbcTemplate jdbcTemplate;
	private AssistantRepository ar;

	
	@GetMapping(value = { "/search3", "/assistant" })
	public String doSearch(String name, Model model) {
		System.out.println("name: " + name);
		if (name == null || "".equals(name)) {
			model.addAttribute("assistant_list", ar.findAll());
		} else {
			model.addAttribute("assistant_list", ar.findByName(name));
		}
		return "assistant";
	}

	@PostMapping("/save4")
	public String add(Assistant t) {
		if (t == null) {
			return "redirect:assistant";
		}
		if (t.getId() != null) {
			ar.update(t);
		} else {
			ar.add(t);
		}
		return "redirect:assistant";
	}

	@GetMapping("/delete3")
	public String add(Integer id) {
		ar.delete(id);
		return "redirect:assistant";
	}
	
	@ResponseBody
	@GetMapping("get_3")
	public Assistant get_3(Integer id) {
		return ar.findById(id);
	}
	
	
}
