package kr.s24.object2.poly;

//부모클래스
class Parent2{
	public void make() {
		System.out.println("부모클래스의 make");
	}
}
//자식클래스
class Child2 extends Parent2{
	@Override
	public void make() {
		System.out.println("자식클래스의 make");
	}
}

public class PolyMain03 {
	public static void main(String[] args) {
		Child2 ch = new Child2();
		ch.make();//재정의된 메서드 호출
		
		System.out.println("---------");
		
		Parent2 p = ch;//자식클래스타입 -> 부모클래스타입 형변환
		               //업캐스팅, 자동적으로 형변환
		p.make();//재정의된 메서드 호출
	}
}




