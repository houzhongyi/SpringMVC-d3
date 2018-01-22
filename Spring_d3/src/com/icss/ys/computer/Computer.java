package com.icss.ys.computer;

public class Computer implements IComputer{

	@Override
	public void add(int a, int b) {
		//System.out.println("计算器启动计算");
		System.out.println(a + b);
		//System.out.println("计算结束");
	}

	@Override
	public void sub(int a, int b) {
		//System.out.println("计算器启动计算");
		System.out.println(a - b);
		//System.out.println("计算结束");
	}

	@Override
	public void mul(int a, int b) {
		//System.out.println("计算器启动计算");
		System.out.println(a * b);
		//System.out.println("计算结束");
	}

	@Override
	public void div(int a, int b) {
		//System.out.println("计算器启动计算");
		System.out.println(a / b);
		//System.out.println("计算结束");
	}

}
