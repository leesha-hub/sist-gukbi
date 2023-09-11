<<<<<<< Updated upstream
package kr.s18.object.statictest;

public class StaticCount {
	//인스턴스 변수 : 객체가 생성될 때 객체에 포함되는 변수
	int c;
	//static(클래스) 변수 : 객체가 생성될 때 포함되지 않음
	static int count;
	
	//생성자
	public StaticCount() {
		c++;
		count++;
	}
}
=======
package kr.s18.object.statictest;

public class StaticCount {
	// 인스턴스 변수 :: 객체가 생성될 때 객체에 포함되는 변수
	int c;
	// static(클래스) 변수 : 객체가 생성될 때 포함되지 않음
	static int count;
	// 생성자
	public StaticCount() {
		c++;
		count++;
	}
}
>>>>>>> Stashed changes
