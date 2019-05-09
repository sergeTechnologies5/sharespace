package com.geek.sharespace;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.geek.sharespace.models.Comment;
import com.geek.sharespace.models.CommentViewModel;

@Controller
public class CommentController {

	@PostMapping("comments")
	public String Index(@Valid CommentViewModel comment, BindingResult result, RedirectAttributes redirectAttr)
	{
		if(SharespaceApplication.getUserRepository().getUserById(comment.getUser()) != null
			|| (comment.getFile() != 0 && SharespaceApplication.getFileRepository().get(comment.getFile())  != null))
		{
			SharespaceApplication.getCommentRepository().AddComment(new Comment(SharespaceApplication.getUserRepository().getUserById(comment.getUser()), SharespaceApplication.getFileRepository().get(comment.getFile()), comment.getMessage()));
		}
		if(comment.getFile() != 0)
			return "redirect:/files/" + comment.getFile();
		return "redirect:/dashboard";
	}	
}
