package kr.s01.exception;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExceptionMain04 {
	
	/*
	 * throws 예약어의 사용
	 * 메서드에 throws 예외 클래스를 명시하면 메서드 내에 try~catch블럭을 생략할 수 있고
	 * 예외가 발생하면 예외를 보관해서 메서드를 호출한 곳에 try~catch블럭을 만들었을 경우
	 * 그 곳으로 예외를 보냄
	 */
	public void printData() throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(
				                  new InputStreamReader(System.in));
		System.out.print("단 입력:");
		          //String -> int
		int dan = Integer.parseInt(br.readLine());
		System.out.println(dan + "단");
		System.out.println("----------------");
		for(int i=1;i<=9;i++) {
			System.out.println(dan + "*" + i + "=" + dan*i);
		}
	}
	
	public static void main(String[] args) {
		ExceptionMain04 ex = new ExceptionMain04();
		try {
			ex.printData();
		}catch(IOException e) {
			System.out.println("입력시 오류 발생");
		}catch(NumberFormatException e) {
			System.out.println("숫자가 아닙니다.");
		}
	}
}





