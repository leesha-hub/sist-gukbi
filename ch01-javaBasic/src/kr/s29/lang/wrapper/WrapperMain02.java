package kr.s29.lang.wrapper;

public class WrapperMain02 {
	public static void main(String[] args) {
		Integer obj1 = 10; //auto boxing
		Integer obj2 = 20; 
		
		Integer result = obj1 + obj2;
		System.out.println(result);
		System.out.println("=====================");
		
		int result2 = obj1 + obj2; //auto unboxing
		System.out.println(result2);
	}
}
