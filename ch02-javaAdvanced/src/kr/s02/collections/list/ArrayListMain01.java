package kr.s02.collections.list;

import java.util.ArrayList;

class A{
	@Override
	public String toString() {
		return "A";
	}
}
class B{}

public class ArrayListMain01 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		System.out.println("요소의 개수 : " + list.size());
	
		//ArrayList에 객체 저장
		list.add(new A());//A -> Object
		list.add(new B());//B -> Object
		list.add("홍길동");//String -> Object
		list.add(100);//int -> Integer -> Object
		
		//저장된 객체의 명세 출력
		System.out.println(list);
		
		//요소의 개수
		System.out.println("요소의 개수 : " + list.size());
	}
}





