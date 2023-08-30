package kr.s02.variable;

public class VariableMain01 {
	public static void main(String[] args) {
		// 변수(Variable)는 값을 저장할 수 있는 메모리의 공간
		
		// 변수 선언
		int num;
		
		// 변수의 초기화
		num = 17;
		
		System.out.println(num);
		System.out.println("--------------------------");
		
		// 변수 선언, 초기화
		int number = 20;
		// 동일한 변수명으로 변수를 선언하면 오류 발생
		//	int number = 30;
		number = 40;

		System.out.println(number);
		System.out.println("--------------------------");
		
		// 동일한 자료형을 사용하기 때문에 두번째 변수명 앞의 자료형은
		// 생략함.
		int a = 10, b =20;
		int result = a+b;
		
		// 출력
		System.out.printf("result = %d%n", result);
		System.out.printf("result = " + result + "%n");
		
		System.out.println("--------------------------");
		
		// 주의사항		
		System.out.println("결과 : " + a + b);
		System.out.println("결과 : " + (a + b));
		
		// int no;
		//	System.out.println(no);
	}
}
