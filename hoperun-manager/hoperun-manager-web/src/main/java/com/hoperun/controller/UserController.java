package com.hoperun.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hoperun.pojo.User;
import com.hoperun.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userList")
	public String getUserList(Model model){
		List<User> list = userService.getUserList();
		
		model.addAttribute("list",list);
		
		return "list";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		
		return "success";
	}
	
	@RequestMapping("/deleteById")
	public String deleteById(@RequestParam("uid") String uid){
		userService.deleteById(uid);
		
		return "success";
//		return "redirect:/userList";
	}
}
