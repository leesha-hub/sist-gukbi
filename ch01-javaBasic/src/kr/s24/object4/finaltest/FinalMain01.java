package kr.s24.object4.finaltest;

class A{
	//지정한 값은 변경 불가능
	final int NUM = 10;//상수
	public static final int NUMBER = 20;
}

public class FinalMain01 {
	public static void main(String[] args) {
		A ap = new A();
		//상수는 변경 불가능
		//ap.NUM = 20;
		System.out.println(ap.NUM);
		
		//static 상수
		System.out.println(A.NUMBER);
		
		//상수
		final int NO = 30;
		System.out.println(NO);
		
	}
}



