package kr.s02.collections.list;

import java.util.ArrayList;

public class ArrayListMain03 {
	public static void main(String[] args) {
		/*
		 * 제네릭 표현 : 객체를 생성할 때 객체에 저장할 수 있는 요소의 타입을 지정
		 */
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");//String
		list.add("김유신");//String
		//ArrayList 객체 생성시 제네릭 표현으로 저장할 요소의 타입을 String으로
		//지정했기 때문에 Integer 타입의 데이터를 저장할 수 없음
		//list.add(1000);
		list.add("박문수");//String
		
		//반복문을 이용한 요소의 출력
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(name);
		}
		System.out.println("--------------");
		
		//확장for문을 이용한 요소의 출력
		for(String name : list) {
			System.out.println(name);
		}
		
	}
}





