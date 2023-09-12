package kr.s24.object3.instanceoftest;

//부모클래스
class Car{
	public void drive() {
		System.out.println("주행~~");
	}
	public void stop() {
		System.out.println("정지!!");
	}
}
//자식클래스
class FireEngine extends Car{
	public void water() {
		System.out.println("물 뿌리기");
	}
}

public class InstanceofMain02 {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		//생성된 객체        사용 가능한 자료형
		if(fe instanceof FireEngine) {
			System.out.println(
					"This is a FireEngine instance");
		}
		
		if(fe instanceof Car) {
			System.out.println(
					"This is a Car instance");
		}
		
		if(fe instanceof Object) {
			System.out.println(
					"This is an Object instance");
		}
		
		
	}
}







