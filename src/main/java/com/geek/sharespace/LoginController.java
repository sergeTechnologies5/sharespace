package com.geek.sharespace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geek.sharespace.models.User;
import com.geek.sharespace.models.UserCredentialsViewModel;

@Controller
public class LoginController {
	
	@GetMapping("login")
	public String index(Model model)
	{
		model.addAttribute("credentials", new UserCredentialsViewModel());
		return "login";
	}	

	@PostMapping("login")
	public String login(Model model, @ModelAttribute UserCredentialsViewModel credentials, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession();
		IUserRepository urepo = SharespaceApplication.getUserRepository();
		urepo.getUsers();
		User user = urepo.getUserByUsername(credentials.getUsername());
		if(user == null || !user.ValidateByPassword(credentials.getPassword()))
		{
			model.addAttribute("credentials",credentials);
			model.addAttribute("error","Incorrect username/password");
			return "login";
		}
		session.setAttribute("user", user);
		return "redirect:dashboard";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:login";
	}

}
