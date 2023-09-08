package kr.s16.object.thistest;

public class ThisMain03 {
	/*
	 * 생성자 내부에서 또 다른 생성자를 호출할 때 this()를 표시함.
	 * this()를 이용해서 또 다른 생성자를 호출하는 경우는 생성자 내부에 반복적인
	 * 코드가 있어서 반복적인 코드를 제거하고 코드를 재사용하고자 할 때 사용함.	 * 
	 */
	public ThisMain03() {
		//this()를 호출 전하기 전에 수행문을 명시하면 오류 발생
		//System.out.println("~~~~~~~~~~~");
		this("바람");
		System.out.println("------------");
	}
	public ThisMain03(int a) {
		this(String.valueOf(a));//int -> String
	}
	public ThisMain03(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		ThisMain03 tm = new ThisMain03();
		ThisMain03 tm2 = new ThisMain03(3000);
		ThisMain03 tm3 = new ThisMain03("Korea");
	}
}



