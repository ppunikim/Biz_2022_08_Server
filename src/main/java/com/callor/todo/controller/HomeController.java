package com.callor.todo.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;


@Controller
public class HomeController {
	
	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(Locale locale) {
		return "home";
	}
	
	@RequestMapping(value="/403",method=RequestMethod.GET)
	public String error403() {
		return "error/403";
	}
	
	@RequestMapping(value="/todo/list", method=RequestMethod.GET)
	public String list(Model model) {
		List<TodoVO> todoList = todoService.selectAll();
		model.addAttribute("TODOLIST",todoList);	
		return "/todo/list";
	}
	
	@RequestMapping(value="/todo/list",method=RequestMethod.POST)
	public String insert(String t_content) {
		todoService.insertTodo(t_content, "aa");
		return "redirect:/todo/list";
	}
	
	@RequestMapping(value="/{seq}/update", method = RequestMethod.GET)
	public String update(
			@PathVariable("seq") long seq, Model model) {
		TodoVO todoVO = todoService.findById(seq);
		model.addAttribute("todo", todoVO);
		return "todo/list";
	}
	@RequestMapping(value="/{seq}/update", method = RequestMethod.POST)
	public String update(@PathVariable("seq") long seq, 
			@ModelAttribute("memoVO") TodoVO todoVO,
			Model model) {
		todoVO.setT_seq(seq);
		todoService.update(todoVO);
		model.addAttribute("todo",todoVO);
		//return String.format("redirect:/todo/%s/list",seq);
		return "redirect:/todo/list";
	}
	
	@RequestMapping(value="/{seq}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("seq") long seq) {
		todoService.delete(seq);
		return "redirect:/todo/list";
	}

	
	
}
