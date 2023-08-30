package kr.s04.operator;

public class OperatorMain01 {
	public static void main(String[] args) {
		System.out.println("===증감연산자===");
		// 증가연산자
		int i = 5;
		// 증가연산자를 변수 앞에 명시하면 변수값을 1 증가시킨 후 증가된
		// 값을 읽어옴
		System.out.println(++i); // 6
		System.out.println("----------------");
		System.out.println(i++);
		System.out.println("----------------");
		System.out.println(i);
	}
}
