package kr.s24.object3.instanceoftest;

//부모클래스
class Parent{
	//Object의 toString 재정의
	@Override
	public String toString() {
		return "Parent 클래스";
	}
}
//자식클래스
class Child extends Parent{
	@Override
	public String toString() {
		return "Child 클래스";
	}
}

public class InstanceofMain01 {
	public static void main(String[] args) {
		Parent p = new Parent();
		
		//컴파일 오류는 없지만 실행시 오류 발생
		//Child ch = (Child)p;
		
		  //생성된 객체   사용 가능한 자료형 
		if(p instanceof Child) {
			//생성된 객체가 Child 타입을 사용할 수 있음
			Child ch2 = (Child)p;
			System.out.println(ch2);
			System.out.println("~~~~~~~~~~~~");
		}else {
			//생성된 객체가 Child 타입을 사용할 수 없음
			System.out.println(p);
			System.out.println("++++++++++++");
		}
	}
}








