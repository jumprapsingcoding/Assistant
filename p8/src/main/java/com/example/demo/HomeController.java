package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "login";
	}
	

	@Autowired
	// private JdbcTemplate jdbcTemplate;
	private TeacherRepository tr;

	@PostMapping("/login")
	public String login(Model model, String account, String password) {
		return "redirect:home";
	}

	@GetMapping(value = { "/search", "/home" })
	public String doSearch(String name, Model model) {
		System.out.println("name: " + name);
		if (name == null || "".equals(name)) {
			model.addAttribute("teacher_list", tr.findAll());
		} else {
			model.addAttribute("teacher_list", tr.findByName(name));
		}
		return "home";
	}

	@PostMapping("/save")
	public String add(Teacher t) {
		if (t == null) {
			return "redirect:home";
		}
		if (t.getId() != null) {
			tr.update(t);
		} else {
			tr.add(t);
		}
		return "redirect:home";
	}

	@GetMapping("/delete")
	public String add(Integer id) {
		tr.delete(id);
		return "redirect:home";
	}
	
	@ResponseBody
	@GetMapping("get")
	public Teacher get(Integer id) {
		return tr.findById(id);
	}
}
