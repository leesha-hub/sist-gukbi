package kr.s04.operator;

public class OperatorMain13 {
	public static void main(String[] args) {
		/*
		 * 제출 - pinos71@daum.net
		 * 
		 * [숙제] A전자대리점에서는 그날 물건 판매액의 15%를 할인 해주기로 했습니다. 
		 * 판매한 상품명과 상품의 단가와 수량을 입력해서 지불 금액을
		 * 출력하는 프로그램을 작성하시오.(단, 출력 시에는 소수점 이하 절삭)
		 * 
		 * [입력예시] 상품명 입력 : 냉장고 단가 입력 : 500000 판매 수량 입력 : 3
		 * 
		 * [출력예시] 냉장고 3대 가격은 1,275,000원
		 */

		java.util.Scanner sc = new java.util.Scanner(System.in);

		String name = ""; // 상품명
		int price = 0; // 단가
		int quantity = 0; // 수량
		float discount = 0.15f; // 할인률

		System.out.println("상품명 입력 : ");
		name = sc.next();

		try {
			System.out.println("단가 입력 : ");
			price = sc.nextInt();
			System.out.println("판매 수량 입력 : ");
			quantity = sc.nextInt();
		} catch (Exception InputMismatchException) {
			System.out.println("[ERROR] 숫자를 입력해주세요.");
			System.exit(0);
		}
		sc.close();

		float avg = (price * quantity) * (1.0f - discount);
		System.out.printf("%s %d대 가격은 %,3.0f원", name, quantity, avg);
	}
}