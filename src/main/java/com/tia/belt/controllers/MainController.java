package com.tia.belt.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tia.belt.models.Priority;
import com.tia.belt.models.Task;
import com.tia.belt.models.User;
import com.tia.belt.services.TaskService;
import com.tia.belt.services.UserService;



@Controller
public class MainController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/login";	
		} 
		Long userId=(Long) session.getAttribute("userid");
        User u = userService.findUserById(userId);
        model.addAttribute("user", u);
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/login";	
		} 
		Long userId=(Long) session.getAttribute("userid");
        User u = userService.findUserById(userId);
        model.addAttribute("user", u);
		model.addAttribute("allTasks", taskService.allTasks());
		model.addAttribute("allPriorities", taskService.allPriorities());
		model.addAttribute("allUsers", taskService.allUsers());
		return "dashboard.jsp";
	}
	
	@GetMapping("/create")
	public String create(@Valid @ModelAttribute("task")Task task, BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/login";	
		} 
		taskService.allTasks();
		model.addAttribute(taskService.allUsers());
		List<User> users = taskService.allUsers();
		model.addAttribute("users", users);
		
		taskService.allPriorities();
		model.addAttribute(taskService.allPriorities());
		List<Priority> priorities = taskService.allPriorities();
		model.addAttribute("priorities", priorities);
	
		return "create.jsp";
	}
	
	@PostMapping("/create")
	public String submitTask(@ModelAttribute("task")Task task, Model model) {
		taskService.createTask(task);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/task/{id}")
	public String task(@PathVariable("id")Long id, @ModelAttribute("task")Task task, Model model, HttpSession session) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/login";	
		} 
		model.addAttribute("task", taskService.findTask(id));
		model.addAttribute("user", taskService.allUsers());
		taskService.allTasks();
		model.addAttribute(taskService.allUsers());
		List<User> users = taskService.allUsers();
		model.addAttribute("users", users);
		
		taskService.allPriorities();
		model.addAttribute(taskService.allPriorities());
		List<Priority> priorities = taskService.allPriorities();
		model.addAttribute("priorities", priorities);
		return "task.jsp";
		
	}
	
	@RequestMapping("/edit/task/{id}")
	public String edit(@Valid @ModelAttribute("task")Task task, BindingResult result, @PathVariable("id")Long id, Model model) {
		model.addAttribute("task", taskService.findTask(id));
		taskService.allTasks();
		model.addAttribute(taskService.allUsers());
		List<User> users = taskService.allUsers();
		model.addAttribute("users", users);
		
		taskService.allPriorities();
		model.addAttribute(taskService.allPriorities());
		List<Priority> priorities = taskService.allPriorities();
		model.addAttribute("priorities", priorities);
		
		return "edit.jsp";
	}
	
	@PostMapping("/edit/task/{id}")
	public String editEvent(@Valid @ModelAttribute("task")Task task, BindingResult result, @PathVariable("id")Long id, Model model) {
		taskService.updateTask(task);
		return "redirect:/task/" + id;
	}
	

}
