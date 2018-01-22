package com.icss.ys.computer;

public class TestComputer {
	public static void main(String[] args) {
		//Computer c = new Computer();
		IComputer c = new TargetProxy(new Computer()).testProxy();
		c.div(2, 3);
	}
}
