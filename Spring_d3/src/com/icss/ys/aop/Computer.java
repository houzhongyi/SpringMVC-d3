package com.icss.ys.aop;

import org.springframework.stereotype.Component;

/**
 * 切入点
 * @author Administrator
 *
 */
@Component
public class Computer{

	
	public void add(int a, int b) {
		//System.out.println("计算器启动计算");
		System.out.println(a + b);
		//System.out.println("计算结束");
		System.out.println(10 / 0);
		
		
		//return a + b;
	}

	
	public void sub(int a, int b) {
		//System.out.println("计算器启动计算");
		System.out.println(a - b);
		//System.out.println("计算结束");
	}


	public void mul(int a, int b) {
		//System.out.println("计算器启动计算");
		System.out.println(a * b);
		//System.out.println("计算结束");
	}

	
	public void div(int a, int b) {
		//System.out.println("计算器启动计算");
		System.out.println(a / b);
		//System.out.println("计算结束");
	}

}
