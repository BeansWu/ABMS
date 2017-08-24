package org.edu.abms.user.controller;

import org.edu.abms.user.entity.User;
import org.edu.abms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam(value="account") String account, 
			@RequestParam(value="password") String password) {
		
		User loginUser = userService.findByAccount(account);
		if(loginUser == null){
			return "user no exist";
		}
		else if(loginUser.getPassword().equals(password)){
			String userType = loginUser.getRoleType().name();
			return userType;
		}else{
			return "wrong password";
		}

	}
}
