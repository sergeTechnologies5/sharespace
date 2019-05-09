package com.geek.sharespace;

import org.springframework.core.io.Resource;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.geek.sharespace.models.Comment;
import com.geek.sharespace.models.CommentViewModel;
import com.geek.sharespace.models.File;
import com.geek.sharespace.models.User;

@Controller
@RequestMapping("/files")
public class FileController {
	
	/*@GetMapping("/")
	public String listUploadedFiles(Model model) throws IOException {
	
	    model.addAttribute("files", storageService.loadAll().map(
	            path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
	                    "serveFile", path.getFileName().toString()).build().toString())
	            .collect(Collectors.toList()));
	
	    return "uploadForm";
	}*/

	@GetMapping("/download/{id:[\\d]+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable int id) {
		File file = SharespaceApplication.getFileRepository().get(id);
	    if(file == null)
	    	return ResponseEntity.notFound().build();
	    file.increaseDownloadCount();
	    Resource rfile = new FileSystemResource(file.getFile());
	    return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
	            "attachment; filename=\"" + file.getFilename() + "\"").body(rfile);
	}

	@GetMapping("/{id:[\\d]+}")
	public String showFile(@PathVariable int id, HttpSession session, Model model) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		File file = SharespaceApplication.getFileRepository().get(id);
		Comment[] comments = SharespaceApplication.getCommentRepository().getComments(file);
	    if(file == null)
	    	return null;
	    model.addAttribute("file", file);
	    model.addAttribute("comments", comments);
		model.addAttribute("newComment", new CommentViewModel());
	    return "file";
	}
	
	@PostMapping("")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
	        RedirectAttributes redirectAttributes, HttpSession session) throws IllegalStateException, IOException {
		if(session.getAttribute("user") == null) {
			return "redirect:login";
		}
		if(!file.getOriginalFilename().equals("") || file.getSize() != 0) {
			File mfile = new File(file, null /*new FileSystemResource("fileStorage/").getFile()*/, (User)session.getAttribute("user"));
			SharespaceApplication.getFileRepository().Add(mfile);
			
		    redirectAttributes.addFlashAttribute("message",
		            "You successfully uploaded " + file.getOriginalFilename() + "!");
		}
	    return "redirect:dashboard";
	}
}
