package com.icss.ys.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * @author Administrator
 *
 */
@Component
@Aspect//定义该对象为一个切面
public class TestAspect {
	/**
	 * 定义一个切入点方法
	 */
	/*@Pointcut("execution(* com.icss.ys.aop.Computer.add(..))")
	public void pc(){
		
	}*/
	/**
	 * 切面方法 ： 前置
	 */
	@Before("execution(* com.icss.ys.aop.Computer.add(..))")
	public void doBefore(JoinPoint j){
		//获得目标方法的信息
		//System.out.println(j.getArgs()[0] + "," + j.getArgs()[1]);
		System.out.println("计算器启动计算");
	}
	
	/**
	 * 切面方法 ： 后置
	 */
	@AfterReturning(value="execution(* com.icss.ys.aop.Computer.add(..))")
	public void doAfterReturn(JoinPoint j,Object r){
		//System.out.println(j.getArgs()[0] + "," + j.getArgs()[1]);
		System.out.println(r);
		System.out.println("计算器结束");
	}
		
	/**
	 * 切面方法 ：最终
	 */
	@After(value="execution(* com.icss.ys.aop.Computer.add(..))")
	public void doAfter(JoinPoint j){
	/*	System.out.println(j.getArgs()[0] + "," + j.getArgs()[1]);*/		
		System.out.println("计算器最终");
	}
	/**
	 * 切面方法 ： 异常
	 */
	@AfterThrowing(value="execution(* com.icss.ys.aop.Computer.add(..))")
	public void doException(JoinPoint j){
		//System.out.println(j.getArgs()[0] + "," + j.getArgs()[1]);
//		System.out.println(e.getMessage());
		System.out.println("计算器异常");
	}
//	/**
//	 * 切面方法 ：环绕
//	 */
//	@Around("execution(* com.icss.ys.aop.Computer.add(..))")
//	public Object doAround(ProceedingJoinPoint p){
//		System.out.println("计算器启动");
//		Object r = null;
//		try{
//			//手动运行目标方法
//			r  = p.proceed();
//			System.out.println(r);
//			System.out.println("后置");
//			
//		}catch(Throwable e){
//			System.out.println("计算器出错");
//			
//		}finally{
//			System.out.println("最终");
//		}
//		return r;		
//	}
}
