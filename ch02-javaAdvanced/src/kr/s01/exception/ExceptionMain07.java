package kr.s01.exception;

import java.util.Scanner;

//사용자 정의 예외클래스
class NegativeNumberUseException extends Exception{
	public NegativeNumberUseException(String str) {
		super(str);
	}
}

public class ExceptionMain07 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("0이상만 입력:");
		try {
			int a = input.nextInt();
			if(a>=0) {
				System.out.println("입력한 숫자 : " + a);
			}else {
				throw new NegativeNumberUseException("음수를 사용할 수 없습니다.");
			}
		}catch(NegativeNumberUseException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println("예외 발생");
		}finally {
			if(input!=null) input.close();
		}
	}
}







