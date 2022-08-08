package com.callor.todo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;
import com.callor.todo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/users")
public class UserController {

	public UserController(UserService userService) {
		this.userService = userService;
	}

	private UserService userService;
	
	@RequestMapping(value="/join", method =RequestMethod.GET)
	public String join() {
		return "/users/join";
	}
	
	@RequestMapping(value="/join", method =RequestMethod.POST)
	public String join(UserVO userVO) {
		userService.insert(userVO);
		return "redirect:/";
	}
	
	// localhost:8080/context/user/login
	@RequestMapping(value="/login", method =RequestMethod.GET)
	public String login(String error, Model model) {
		model.addAttribute("error",error);
		return null;
	}
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String login(UserVO userVO, HttpSession httpSession) {
//		httpSession.setAttribute("USER", userVO);
//		return "redirect:/";
//	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("USERNAME"); //세션 정보 제거
		return "redirect:/";
	}
	
	@RequestMapping(value="/mypage", method =RequestMethod.GET)
	public String mypage() {
		return "/users/mypage";
	}
	
}
