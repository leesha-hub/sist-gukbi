package kr.s08.inner.local;

public class LocalMain01 {
	
	//멤버메서드
	public void innerTest() {
		//로컬내부클래스
		class Inner{
			public void getData() {
				System.out.println("Local내부클래스");
			}
		}
		//로컬내부클래스 객체 생성
		Inner i = new Inner();
		i.getData();
	}
	
	public static void main(String[] args) {
		LocalMain01 lo = new LocalMain01();
		lo.innerTest();
	}
}



