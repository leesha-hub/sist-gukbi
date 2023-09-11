package kr.s19.object.array;

class Car{
	//멤버 변수
	private String color;
	private int speed;
	
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSpeed() {
		return speed;
	}
}


public class CarMain {
	public static void main(String[] args) {
		//배열 선언 및 생성
		Car[] carArray = new Car[3];
		
		for(int i=0;i<carArray.length;i++) {
			System.out.println(carArray[i]);
		}
		System.out.println("-------------------");
		
		carArray[0] = new Car();
		carArray[0].setColor("검정색");
		carArray[0].setSpeed(100);
		
		carArray[1] = new Car();
		carArray[1].setColor("흰색");
		carArray[1].setSpeed(200);
		
		carArray[2] = new Car();
		carArray[2].setColor("파란색");
		carArray[2].setSpeed(300);
		
		//배열의 요소 출력
		for(int i=0;i<carArray.length;i++) {
			System.out.println(carArray[i]);
		}
		System.out.println("---------------");
		
		//Car 객체의 멤버 변수에 저장된 데이터를 출력
		for(int i=0;i<carArray.length;i++) {
			System.out.println("carArray["+i+"]: 색상->" + 
		            carArray[i].getColor() 
		            + ",스피드->" + carArray[i].getSpeed());
		}
		System.out.println("--------------");
		for(Car car : carArray) {
			System.out.println("색상 : " + car.getColor() 
			  + ", 스피드 : " + car.getSpeed());
		}
		
	}
}