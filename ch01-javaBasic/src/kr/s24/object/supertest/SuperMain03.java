package kr.s24.object.supertest;

//부모클래스
class People{
	int a = 100;
	
	//생성자
	public People() {
		//Object의 인자가 없는 생성자 호출
		super();
	}
	
}
//자식클래스
class Student extends People{
	int b = 200;
	
	//생성자
	public Student() {
		//부모클래스의 인자가 없는 생성자 호출
		super();
	}
	
}

public class SuperMain03 {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.a);
		System.out.println(s.b);
	}
}





