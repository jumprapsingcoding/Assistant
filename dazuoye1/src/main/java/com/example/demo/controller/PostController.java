package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.entity.Assistant;
import com.example.demo.entity.Post;
import com.example.demo.entity.Student;
import com.example.demo.repository.AssistantRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.StudentRepository;

@Controller
public class PostController {

	@Autowired
	// private JdbcTemplate jdbcTemplate;
	private AssistantRepository ar2;


	@Autowired
	// private JdbcTemplate jdbcTemplate;
	private PostRepository pr;
	@Autowired
	// private JdbcTemplate jdbcTemplate;
	private StudentRepository sr;

	@GetMapping("/getassistant")
	public String doSearch(Model model) {
		model.addAttribute("post_list", pr.findAll());
		return "getassistant";
	}

	@PostMapping("/save5")
	public String add(Post p) {
		
		pr.add(p);
		
		return "redirect:getassistant";
	}

	@GetMapping("/tiao")
	public String add2(Model model,Integer id,String postclass,String postteacher) {
		model.addAttribute("student_list",sr.findAll());
		model.addAttribute("postid",id);
		model.addAttribute("postclass",postclass);
		model.addAttribute("postteacher",postteacher);
		
		
		return "student";
	}
	
	@ResponseBody
	@GetMapping("get_5")
	public Post get_5(Integer id) {
		return pr.findById(id);
	}
	
	@GetMapping("/student")
	public String doSearch( ) {
		
		return "student";
	}
	@ResponseBody
	@GetMapping("get_6")
	public Student get_6(Integer id) {
		return sr.findById(id);
	}
	

	@GetMapping("/search7")
	public String doSearch2(Assistant as,Integer id2,int postid) {
//		if (name == null || "".equals(name)) {
//			model.addAttribute("teacher_list", tr.findAll());
//		} else {
//			model.addAttribute("teacher_list", tr.findByName(name));
//		}
		
		
		ar2.add(as);
		pr.delete(postid);
		sr.delete(id2);
		
		return "student";
	
	}
	
	
	
}
