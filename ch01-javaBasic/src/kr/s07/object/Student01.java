package kr.s07.object;

public class Student01 {
	// 멤버 변수
	String name;
	int age;
	
	public static void main(String[] args) {
		// 객체 선언
		Student01 student;
		// 객체 생성
		student = new Student01();
		
		// 객체의 멤버 변수에 값 할당
		student.name = "홍길동";
		student.age = 20;
		
		// 객체의 멤버 변수 값 출력
		System.out.println(student.name + ", " + student.age);
	}
}