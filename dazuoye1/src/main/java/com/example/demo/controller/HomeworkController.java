package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Homework;
import com.example.demo.repository.HomeworkRepository;

@Controller
public class HomeworkController {


	
	@Autowired
	// private JdbcTemplate jdbcTemplate;
	private HomeworkRepository hr;

	@GetMapping(value = { "/search2", "/ManagerHomework" })
	public String doSearch2(String grade, Model model) {
		System.out.println("grade: " + grade);
		if (grade == null || "".equals(grade)) {
			model.addAttribute("homework_list", hr.findAll());
		} else {
			model.addAttribute("homework_list", hr.findByGrade(grade));
		}
		return "ManagerHomework";
	}

	@PostMapping("/save2")
	public String add2_2(Homework t) {
		if (t == null) {
			return "redirect:ManagerHomework";
		}
		if (t.getId() != null) {
			hr.update(t);
		} else {
			hr.add(t);
		}
		return "redirect:ManagerHomework";
	}
	
	
	@PostMapping("/save3")
	public String add2_3(Homework t) {
		if (t == null) {
			return "redirect:ManagerHomework";
		}
		if (t.getId() != null) {
			hr.update2(t);
		} else {
			hr.add(t);
		}
		return "redirect:ManagerHomework";
	}
	
	

	@GetMapping("/delete2")
	public String delete(Integer id) {
		hr.delete(id);
		return "redirect:ManagerHomework";
	}
	
	@ResponseBody
	@GetMapping("get_2")
	public Homework get_2(Integer id) {
		return hr.findById(id);
	}
	
}
