package kr.s02.variable;

public class VariableMain02 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 정수를 담을 수 있는 변수를 3개 지정한다.
		 * 변수명은 각각 a,b,c라고 지정하고 원하는 정수로 초기화 한다
		 * a+b 연산 후 출력할 때
		 * (예) "결과 = 50" 형식으로 출력한다.
		 * c에 저장된 데이터를 80으로 변경해서 
		 * (예) "c = 80" 형식으로 출력하시오.
		 * */
		
		int a = 20;
		int b = 30;
		
		System.out.println("결과 = " + (a+b));
		System.out.printf("결과 = %d%n",  + (a+b));
		
		int c = 0;
		c = 80;
		
		System.out.println("c = " + c);
		System.out.printf("c = %d", c);
	}
}
