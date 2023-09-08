package kr.s17.object.training;

public class AnimalMain {
	/*
	 * [실습]
	 * 1. 객체 생성 : 인자가 있는 생성자로 객체 생성
	 * 2. 생성된 객체의 멤버 변수에 저장된 정보 출력
	 *    이름 : 기러기
	 *    나이 : 3살
	 *    비행 여부 : 가능
	 * 3. 객체 생성 : 인자가 없는 생성자로 객체 생성
	 * 4. 이름, 나이, 비행 여부를 저장
	 * 5. 생성된 객체의 멤버 변수에 저장된 정보 출력
	 *    이름 : 기린
	 *    나이 : 10살
	 *    비행 여부 : 불가능   
	 */
	public static void main(String[] args) {
		//인자가 있는 생성자를 이용해서 객체 생성
		Animal a1 = new Animal("기러기",3,true);
		
		System.out.println("이름 : " + a1.getName());
		System.out.println("나이 : " + a1.getAge() + "살");
		System.out.println("비행 여부 : " + printFly(a1.isFly()));
		System.out.println("-----------------------");
		
		//인자가 없는 생성자를 이용해서 객체 생성
		Animal a2 = new Animal();
		
		a2.setName("기린");
		a2.setAge(10);
		a2.setFly(false);
		
		System.out.println("이름 : " + a2.getName());
		System.out.println("나이 : " + a2.getAge() + "살");
		System.out.println("비행 여부 : " + printFly(a2.isFly()));		
	}
	
	public static String printFly(boolean fly) {
		return fly ? "가능" : "불가능";
	}
	
}






