package com.icss.ys.computer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类： 定义重复出现横向代码，植入到某些接口，某些类的某些位置
 * @author Administrator
 *
 */
public class TargetProxy {
	
	private IComputer computer;

	public TargetProxy(IComputer computer) {
		super();
		this.computer = computer;
	}
	/**
	 * 代理函数
	 */
	public IComputer testProxy(){
		//加载类
		ClassLoader loader = computer.getClass().getClassLoader();
		//定义代理的接口数组
		Class[] interfaces = new Class[]{IComputer.class};
		//监听
		InvocationHandler handler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object arg0, Method method, Object[] args) throws Throwable {
				Object result = null;
				System.out.println("计算器启动计算");
				result = method.invoke(computer, args);
				System.out.println("计算结束");
				return result;
			}
		};
		return (IComputer)Proxy.newProxyInstance(loader, interfaces, handler);
	}
	
}
