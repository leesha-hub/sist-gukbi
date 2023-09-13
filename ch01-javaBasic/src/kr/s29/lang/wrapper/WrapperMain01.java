package kr.s29.lang.wrapper;

public class WrapperMain01 {
	public static void main(String[] args) {
		boolean b = true; //기본자료형 데이터
		Boolean wrap_b = new Boolean(b); //기본자료형 데이터 -> 참조자료형 데이터
		boolean b2 = wrap_b.booleanValue(); //참조자료형 데이터 -> 기본자료형 데이터
		System.out.println(b2);
		System.out.println("=========================");
		
		//Character 객체 생성
		Character wrap_c = 'A'; // auto boxing
		System.out.println(wrap_c); //auto unboxing
	}
}
