package kr.s22.object.extention;

//부모클래스
class GrandParent{
	public String getCar() {
		return "구형 자동차";
	}
}

//자식클래스
class Father extends GrandParent{
	/*
	 * Method Overriding, 메서드 재정의
	 * 상속관계에서 자식클래스에 메서드 재정의를 하면 부모클래스의 
	 * 메서드가 호출되는 것이 아니라 자식클래스의 메서드가 호출됨
	 */
	public String getCar() {
		return "신형 자동차";
	}
}

class Oncle extends GrandParent{
	
}

public class OverridingMain01 {
	public static void main(String[] args) {
		Father ft = new Father();
		System.out.println(ft.getCar());
		
		Oncle oc = new Oncle();
		System.out.println(oc.getCar());
	}
}



