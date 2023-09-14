package kr.s24.object5.abs;

abstract class AbsEx1{
	int a = 100;
	public void make() {
		System.out.println("make 메서드");
	}
	//추상메서드
	public abstract void play();
	public abstract void take();
}

//추상클래스에 상속
//추상클래스를 추상클래스에 상속하면 추상메서드 구현 의무가 없음
abstract class AbsEx2 extends AbsEx1{
	//추상메서드 구현
	@Override
	public void play() {
		System.out.println("play 메서드");
	}
	//추상메서드 
	public abstract void sound();
}

public class AbstractMain04 extends AbsEx2{
	//추상메서드 구현
	@Override
	public void take() {
		System.out.println("take 메서드");
	}
	@Override
	public void sound() {
		System.out.println("sound 메서드");
	}
	
	public static void main(String[] args) {
		AbstractMain04 ab = new AbstractMain04();
		ab.make();
		ab.play();
		ab.take();
		ab.sound();
	}
}





