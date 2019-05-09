package com.geek.sharespace;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.geek.sharespace.models.SignupViewModel;
import com.geek.sharespace.models.User;
import com.geek.sharespace.models.UserCredentialsViewModel;

@Controller
public class SignupController {

	@GetMapping("/signup")
	public String Index(Model model)
	{
		model.addAttribute("userDetails", new SignupViewModel());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String Signup( @Valid @ModelAttribute("userDetails") SignupViewModel userDetails, BindingResult bresult)
	{
		if(userDetails.getUsername() != null && SharespaceApplication.getUserRepository().getUserByUsername(userDetails.getUsername()) != null)
		{
			bresult.reject("username","User Already Exists");
		}
		if(bresult.hasErrors())
		{
			return "signup";
		}
		User user = new User(userDetails.getUsername(), userDetails.getPassword(), userDetails.getEmail(), userDetails.getFirstname(), userDetails.getLastname());
		SharespaceApplication.getUserRepository().AddUser(user);
		return "redirect:login";
	}
}
