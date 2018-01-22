package com.icss.ys.user.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.ys.user.controller.UserController;
import com.icss.ys.user.pojo.Users;

public class TestUser {
	@Test
	public void login(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		UserController c = (UserController)ac.getBean("userController");
		System.out.println(c.getService().login(new Users("a100xxxx","123456")));
	}
}
