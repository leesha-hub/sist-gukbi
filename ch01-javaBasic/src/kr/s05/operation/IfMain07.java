package kr.s05.operation;

public class IfMain07 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 정수 하나를 입력하여 짝수면 10을 더하고 홀수이면 20를
		 * 더하여 결과를 출력하시오.
		 * 
		 * [입력 예시]
		 * 정수 하나 입력:5
		 * 
		 * [출력 예시]
		 * 결과 : 25
		 */
		
		java.util.Scanner input = 
				new java.util.Scanner(System.in);
		int a, result;
		System.out.print("정수 하나 입력>");
		a = input.nextInt();
		
		if(a%2==0) {//짝수
			result = a + 10;
		}else {//홀수
			result = a + 20;
		}
		
		System.out.printf("결과 : %d", result);
		
	}
}





