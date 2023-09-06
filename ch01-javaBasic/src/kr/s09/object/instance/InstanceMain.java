package kr.s09.object.instance;

public class InstanceMain {
	//클래스의 기본 구조
	//멤버 변수
	int var1; 
	String var2;
	
	//생성자
	public InstanceMain() {}
	
	//멤버 메서드
	public int sum(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		//객체 선언 및 생성
		//자료형    참조자료형      생성자
		InstanceMain me = new InstanceMain();
		System.out.println("me : " + me);
		
		int result = me.sum(5, 6);
		System.out.println("result = " + result);
	}
	
}



