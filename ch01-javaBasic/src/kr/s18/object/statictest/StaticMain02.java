package kr.s18.object.statictest;

public class StaticMain02 {
	
	//인스턴스 변수
	int a;
	//static(클래스) 변수
	static String s;
	
	public static void main(String[] args) {
		s = "서울";
		System.out.println(s);
		System.out.println("---------");
		
		//인스턴스 변수는 객체 생성 후에 호출해야 사용 가능
		//a = 1000;
		StaticMain02 sm = new StaticMain02();
		sm.a = 1000;
		System.out.println(sm.a);
		
		
	}
}




