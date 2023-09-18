package kr.s10.inner.anony;

class Inner6{
	public void disp() {
		System.out.println("부모클래스의 disp");
	}
}

public class AnonyMain {
	
	public void make() {
		//익명내부클래스
		Inner6 i = new Inner6() {
			@Override
			public void disp() {
				System.out.println("자식클래스 disp");
			}
		};
		//메서드 호출
		i.disp();
	}
	
	public static void main(String[] args) {
		AnonyMain an = new AnonyMain();
		an.make();
	}
}




