package com.icss.ys.user.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.icss.ys.user.pojo.Users;
import com.icss.ys.user.service.UsersService;

@Controller
public class UserController {
	@Autowired
	private UsersService service ;

	public UsersService getService() {
		return service;
	}

	public void setService(UsersService service) {
		this.service = service;
	}
	
}
