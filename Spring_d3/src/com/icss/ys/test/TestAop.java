package com.icss.ys.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.ys.aop.Computer;

public class TestAop {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Computer c = (Computer)ac.getBean("computer");
		c.add(2, 3);
	}

}
