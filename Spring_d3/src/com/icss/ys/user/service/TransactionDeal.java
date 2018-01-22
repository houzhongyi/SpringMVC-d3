package com.icss.ys.user.service;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 事务切面： 
 * 记录事务的开始和结束
 * 打印事务开始 ：前置
 * 进行中： 有异常 打印 回滚
 * 		  无异常 正常提交
 * @author Administrator
 *
 */
@Component
@Aspect
public class TransactionDeal {
	/*切面方法*/
	@Around("execution(* com.icss.ys.user.service.UsersService.*(..))")
	public void tx(ProceedingJoinPoint p ){
		System.out.println("事务处理开始" + new Date());
		//conn.setAutoCommit(false);
		//调用目标方法
		try {
			Object o = p.proceed();//执行业务逻辑方法
			System.out.println("执行成功，提交");
			//conn.commit();
		}
		catch (Throwable e) {
			System.out.println("实现代码的回滚");
			//conn.rollback()
		}finally{
			System.out.println("资源关闭");
			//conn.close;
		}		
	}
}
