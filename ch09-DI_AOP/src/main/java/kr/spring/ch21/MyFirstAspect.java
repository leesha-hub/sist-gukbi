package kr.spring.ch21;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//공통 기능을 구현한 클래스
@Aspect
public class MyFirstAspect {
	
	//핵심 기능이 있는 객체의 메서드 검색
	@Pointcut("execution(public String launch())")
	public void getPointcut() {}
	
	@Before("getPointcut()")
	public void before() {
		//메서드 시작 직전에 동작하는 어드바이스
		System.out.println("Hello Before! **메서드가 호출되기 전에 나온다!");
	}
	
	@AfterReturning(value="getPointcut()",returning="msg")
	public void afterReturning(String msg) {
		//메서드 호출이 예외를 내보내지 않고 종료했을 때 동작하는 어드바이스
		System.out.println(
		"Hello AfterReturning! **메서드가 호출한 후에 나온다! 전달된 객체 : " + msg);
	}
	
	@AfterThrowing(value="getPointcut()",throwing="ex")
	public void afterThrowing(Throwable ex) {
		//메서드 호출이 예외를 던졌을 때 동작하는 어드바이스
		System.out.println("Hello AfterThrowing! **예외가 생기면 나온다!");
	}
	
	@After("getPointcut()")
	public void after() {
		//메서드 종료 후에 동작하는 어드바이스
		System.out.println("Hello After! **메서드가 호출된 후에 나온다");
	}
	
	@Around("getPointcut()")
	public String around(ProceedingJoinPoint joinPoint)
	                                         throws Throwable{
		//메서드 호출 전후에 동작하는 어드바이스
		System.out.println(
				"Hello Around before **메서드가 호출되기 전에 나온다!");
		String s = null;
		try {
			//핵심 기능을 수행하는 메서드를 호출하고 결과값을 반환
			s = (String)joinPoint.proceed();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println(
			"Hello Around after! **메서드가 호출된 후에 나온다! 반환된 객체 : " + s);
		}	
		return s;
	}	
}