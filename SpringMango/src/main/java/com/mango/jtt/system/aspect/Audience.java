package com.mango.jtt.system.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {
	/**
	 * 目标方法执行之前调用
	 */
	@Before("execution(** com.mango.jtt.controller.UserController.*(..))")
	public void silenceCellPhone() {
		System.out.println("Silencing cell phones --------------------------------------");
	}

	/**
	 * 目标方法执行之前调用
	 */
	@Before("execution(** com.mango.jtt.controller.UserController.*(..))")
	public void takeSeats() {
		System.out.println("Taking seats ++++++++++++++++++++++++++++");
	}

	/**
	 * 目标方法执行完后调用
	 */
	@AfterReturning("execution(** com.mango.jtt.controller.UserController.*(..))")
	public void applause() {
		System.out.println("CLAP CLAP CLAP");
	}

	/**
	 * 目标方法发生异常时调用
	 */
	@AfterThrowing("execution(** com.mango.jtt.controller.UserController.*(..))")
	public void demandRefund() {
		System.out.println("Demanding a refund");
	}

}
