package webadv.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webadv.example.repository.TeacherRepository;

@Controller
public class HomeController {	
	@Autowired
	private TeacherRepository tr;	
	@PostMapping("/login")
	public String login(Model model,String account, String password) {
		return null;
	}
	
	@GetMapping("/home")
	public String home(Model model) {	
		model.addAttribute("teacher_list",tr.findAll());
			return "home";
	}
}
