package com.geek.sharespace;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geek.sharespace.models.CommentViewModel;

@Controller
public class DashboardController {

	@RequestMapping("dashboard")
	public String Index(Model model, HttpSession session)
	{
		if(session.getAttribute("user") == null) {
			return "redirect:login";
		}
		model.addAttribute("comment_repository", SharespaceApplication.getCommentRepository());
		model.addAttribute("file_repository", SharespaceApplication.getFileRepository());
		model.addAttribute("newComment", new CommentViewModel());
		return "dashboard";
	}
}
