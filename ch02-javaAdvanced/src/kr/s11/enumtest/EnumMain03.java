package kr.s11.enumtest;

//열거형 상수
enum Item{
	ADD, DEL, SEARCH, CANCEL
}

public class EnumMain03 {
	public static void main(String[] args) {
		System.out.println(Item.ADD);
		System.out.println(Item.DEL);
		System.out.println(Item.SEARCH);
		System.out.println(Item.CANCEL);
		System.out.println("---------------");
		
		//values() 메서드는 열거 타입의 모든 열거 객체들을 배열로 만들어 반환
		Item[] items = Item.values();
		System.out.println("items.length : " + items.length);
		//반복문을 이용해서 상수 값 및 상수의 순서 값 출력
		for(Item n : items) {
			System.out.println(n + ":" + n.ordinal());
		}	
	}
}





