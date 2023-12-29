package kr.spring.ch20;

//공통 기능을 수행하는 클래스
public class MyFirstAdvice {
	/*
	 * 구현 가능한 Advice(언제 공통 기능을 핵심 로직에 적용할 지를 정의) 종류
	 * 종류						설명
	 * Before Advice			대상 객체의 메서드 호출 전에 공통 기능을 실행
	 * After Returning Advice	대상 객체의 메서드가 예외 없이 실행한 이후에
	 *                          공통 기능을 실행
	 * After Throwing Advice	대상 객체의 메서드를 실행하는 도중 예외가 
	 *                          발생한 경우에 공통 기능을 실행 
	 * After Advice				대상 객체의 메서드를 실행하는 도중 예외가
	 *                          발생했는지의 여부와 상관없이 메서드 실행 후
	 *                          공통 기능을 실행(try~catch~finally의 
	 *                          finally 블럭과 비슷)                                                   
	 * Around Advice			대상 객체의 메서드 실행 전, 후 또는 예외
	 *                          발생 시점에 공통 기능을 실행하는데 사용
	 */
	public void before() {
		System.out.println("Hello Before! **메서드가 호출되기 전에 나온다!");
	}
}
