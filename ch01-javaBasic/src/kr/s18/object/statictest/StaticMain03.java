package kr.s18.object.statictest;

public class StaticMain03 {
	//인스턴스 변수
	String s1 = "여름";
	//static(클래스) 변수
	static String s2 = "겨울";
	
	//static 메서드
	public static String getString() {
		return s2;
	}
	
	public static void main(String[] args) {
		System.out.println(getString());
	}
}
