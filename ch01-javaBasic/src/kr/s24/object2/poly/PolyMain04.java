package kr.s24.object2.poly;

//부모클래스
class Product{
	int price; //제품의 가격
	int bonusPoint; //제품 구매시 제공하는 보너스 점수
	
	//인자가 있는 생성자
	public Product(int price) {
		this.price = price;
		bonusPoint = price/10;
	}
	
	//제품의 이름을 반환
	public String getName() {
		return "상품";
	}
	
}

class Tv extends Product{
	public Tv() {
		super(100);//Tv의 가격
	}
	//메서드 오버라이딩(재정의)
	@Override
	public String getName() {
		return "Tv";
	}
	
}
class Computer extends Product{
	public Computer() {
		super(200);//Computer 가격
	}
	//메서드 오버라이딩(재정의)
	@Override
	public String getName() {
		return "Computer";
	}
}
class Audio extends Product{
	public Audio() {
		super(300); //Audio의 가격
	}
	//메서드 오버라이딩(재정의)
	@Override
	public String getName() {
		return "Audio";
	}
}


class Buyer{
	private int money = 1000;//구매자 보유 금액
	private int bonusPoint = 0;//보너스 점수
	
	//상품 구매
	public void buy(Product p) {
		if(money < p.price) {
			System.out.println(
					"잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		money -= p.price; //차감
		bonusPoint += p.bonusPoint; //누적
		
		System.out.println(p.getName() + "을/를 구입하셨습니다.");
		System.out.println("현재 남은 돈은 " + money + "만원입니다.");
		System.out.println("현재 보너스 점수는 " + bonusPoint + "점입니다.");
		
	}
}

public class PolyMain04 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		Audio au = new Audio();
		
		//Tv를 구매
		b.buy(tv);//Tv -> Product 형변환
		//Computer를 구매
		b.buy(com);//Computer -> Product 형변환
		//Audio를 구매
		b.buy(au);//Audio -> Product 형변환
		
	}
}










